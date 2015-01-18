package com.tutorial.rest.controller;

import com.tutorial.domain.User;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mli on 18/01/15.
 */
@RestController
public class RestUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User userDetails(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/users")
    public List<User> allUserDetails() {
        return userService.findAllUsers();
    }
}
