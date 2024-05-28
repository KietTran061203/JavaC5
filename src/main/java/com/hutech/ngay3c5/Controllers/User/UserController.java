package com.hutech.ngay3c5.Controllers.User;

import com.hutech.ngay3c5.Entities.Student;
import com.hutech.ngay3c5.Entities.User;
import com.hutech.ngay3c5.RequestEntities.RequestCreateStudent;
import com.hutech.ngay3c5.RequestEntities.RequestCreateUser;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateStudent;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateUser;
import com.hutech.ngay3c5.Services.StudentService;
import com.hutech.ngay3c5.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public String ShowAllStudents(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "User/index";
    }
    @GetMapping("/edit/{id}")
    public String ShowUserForm(@PathVariable String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "User/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditUser(RequestUpdateUser requestUpdateUser){
        userService.updateUser(requestUpdateUser.getId(),requestUpdateUser);
        return "redirect:/users";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "User/create";
    }
    @PostMapping("/create")
    public String SaveCreateUser(RequestCreateUser requestCreateStudent){
        userService.CreateUser(new RequestCreateUser());
        return "redirect:/users";
    }
    @GetMapping("/view/{id}")
    public String ViewStudent(@PathVariable String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "User/view";
    }
}
