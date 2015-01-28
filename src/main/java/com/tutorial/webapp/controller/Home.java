package com.tutorial.webapp.controller;

import com.tutorial.domain.entity.User;
import com.tutorial.domain.entity.UserDetails;
import com.tutorial.service.UserService;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

    private Logger LOG = LoggerFactory.getLogger(Home.class);

    private static String message = "Welcome to your 1st Maven Spring project !";
    
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView index() {
//        User user = createUser();
//        userService.saveUser(user);
//        LOG.info("User's age is: {}", user);
        return new ModelAndView("index", "message", message);
    }

    @RequestMapping("/hello")
    public ModelAndView showMessage() {
        System.out.println("from controller");
        return new ModelAndView("hello", "message", message);
    }

    private User createUser() {
        User user = new User();
        user.setUsername("mlii");
        user.setPassword("password");
        UserDetails details = new UserDetails();
        details.setFirstName("Ming");
        details.setLastName("Li");
        details.setDateOfBirth(new LocalDate(1986, 6, 17));
        details.setTitle("Mr.");
        details.setUser(user);
        user.setUserDetails(details);
        return user;
    }
    
}  