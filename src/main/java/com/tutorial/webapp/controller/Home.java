package com.tutorial.webapp.controller;

import com.tutorial.domain.User;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {
    
    @Autowired
    private UserService userService;
    
    String message = "Welcome to your 1st Maven Spring project !";

    @RequestMapping("/index")
    public ModelAndView index() {
        userService.saveUser(new User("Ming Li", "123456"));
        System.out.println("from controller");
        return new ModelAndView("index", "message", message);
    }
    
    @RequestMapping("/hello")
    public ModelAndView showMessage() {
        System.out.println("from controller");
        return new ModelAndView("hello", "message", message);
    }
}  