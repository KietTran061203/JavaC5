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
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/roles")
public class RoleRestController {
    @Autowired
    private RoleService roleService;

    @PostMapping("")
    public Role CreateRole(@RequestBody RequestCreateRole requestCreateRole) {
        return roleService.CreateRole(requestCreateRole);
    }
    @GetMapping("")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable String id) {
        return roleService.getRoleById(id);
    }
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable String id, @RequestBody RequestUpdateRole requestUpdateRole) {
        return roleService.updateRole(id, requestUpdateRole);
    }
}
