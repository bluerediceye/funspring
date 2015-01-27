package com.tutorial.webapp.controller;

import com.tutorial.domain.entity.User;
import com.tutorial.service.UserService;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

    String message = "Welcome to your 1st Maven Spring project !";
    private Logger LOG = LoggerFactory.getLogger(Home.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView index() {
        User user = new User();
        user.setCreationDate(new DateTime());
        userService.saveUser(user);
        LOG.info("User's age is: {}", user.getUserDetails().getFullName());
        return new ModelAndView("index", "message", message);
    }

    @RequestMapping("/hello")
    public ModelAndView showMessage() {
        System.out.println("from controller");
        return new ModelAndView("hello", "message", message);
    }
}  