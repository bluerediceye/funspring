package com.tutorial.rest.controller;

import com.tutorial.domain.entity.Group;
import com.tutorial.domain.entity.User;
import com.tutorial.repository.GroupJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mli on 20/01/15.
 */
@RestController
public class RestGroupController {

    @Autowired
    private GroupJpaRepository groupJpaRepository;

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public void createGroup() {
        Group group = new Group();
        group.setName("Java");

        User user = new User();
        user.setUsername("Ming");
        user.setPassword("password");
        user.setGroup(group);

        group.getUsers().add(user);

        groupJpaRepository.save(group);
    }
}
