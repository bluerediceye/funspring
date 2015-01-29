package com.tutorial.webapp.controller;

import com.tutorial.domain.entity.User;
import com.tutorial.domain.entity.UserDetails;
import com.tutorial.service.UserService;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    static int i = 5;

    private Logger LOG = LoggerFactory.getLogger(HomeController.class);

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

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasPermission(#user,'createUser')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(@ModelAttribute("user") User user) {
        LOG.info("Create an user !!!");
        user.setUsername("mli" + i++);
        user.setPassword("password");
        user.setEnabled(true);
        UserDetails details = new UserDetails();
        details.setFirstName("Ming");
        details.setLastName("Li");
        details.setDateOfBirth(new LocalDate(1986, 6, 17));
        details.setTitle("Mr.");
        details.setUser(user);
        user.setUserDetails(details);
        userService.saveUser(user);
        return "index";
    }
    
}  