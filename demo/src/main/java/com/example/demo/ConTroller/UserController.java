package com.example.demo.ConTroller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/Users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/users-list")
    public String list(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/Users/users-list";
    }
}
