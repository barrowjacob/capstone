package com.rto.capstone.controllers;

import com.rto.capstone.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private UserRepository userDao;

    public LoginController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users/login")
    public String showLogin() {
        return "users/login";
    }

    @PostMapping("/users/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        model.addAttribute("username", username);
        return "users/profile";
    }

    @GetMapping("/profile")
    public String showProfile() {
        return "users/profile";
    }

//    @GetMapping(path = "/profile")
//    public String getImgInfoForUser(Model m, @PathVariable long id)
//    {
//
//        m.addAttribute("user", userDao.getOne(id));
//        return "users/profile";
//    }

//    @GetMapping("/logout")
//    public String logout() {
//        return "views/login";
//    }
}