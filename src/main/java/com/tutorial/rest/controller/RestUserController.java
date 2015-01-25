package com.tutorial.rest.controller;

import com.tutorial.domain.entity.User;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/user/name/{name}", method = RequestMethod.GET)
    public List<User> usersDetailsByName(@PathVariable String name) {
        return userService.findUsersByName(name);
    }

    @RequestMapping(value = "/users")
    public List<User> allUserDetails() {
        return userService.findAllUsers();
    }
}
