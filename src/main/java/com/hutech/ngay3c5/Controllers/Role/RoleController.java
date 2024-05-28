package com.hutech.ngay3c5.Controllers.Role;

import com.hutech.ngay3c5.Entities.Role;
import com.hutech.ngay3c5.Entities.Student;
import com.hutech.ngay3c5.RequestEntities.RequestCreateRole;
import com.hutech.ngay3c5.RequestEntities.RequestCreateStudent;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateRole;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateStudent;
import com.hutech.ngay3c5.Services.RoleService;
import com.hutech.ngay3c5.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public String ShowAllRoles(Model model){
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "Role/index";
    }
    @GetMapping("/edit/{id}")
        public String ShowRoleForm(@PathVariable String id, Model model){
        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "Role/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditRole(RequestUpdateRole requestUpdateRole){
        roleService.updateRole(requestUpdateRole.getRole_id(),requestUpdateRole);
        return "redirect:/roles";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        Role role = new Role();
        model.addAttribute("role", role);
        return "Role/create";
    }
    @PostMapping("/create")
    public String SaveCreateRole(RequestCreateRole requestCreateRole){
        roleService.CreateRole(requestCreateRole);
        return "redirect:/roles";
    }
    @GetMapping("/view/{id}")
    public String ViewRole(@PathVariable String id, Model model){
        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "Role/view";
    }
}
