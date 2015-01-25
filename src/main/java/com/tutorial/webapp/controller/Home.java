package com.tutorial.webapp.controller;

import com.tutorial.domain.User;
import com.tutorial.service.UserService;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

    String message = "Welcome to your 1st Maven Spring project !";
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView index() {
        userService.saveUser(new User("Ming Li", "123456", new LocalDate()));
        System.out.println("from controller");
        return new ModelAndView("index", "message", message);
    }

    @RequestMapping("/hello")
    public ModelAndView showMessage() {
        System.out.println("from controller");
        return new ModelAndView("hello", "message", message);
    }
}  