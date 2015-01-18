package com.tutorial.service;

import com.tutorial.domain.User;

import java.util.List;

/**
 * Created by mli on 18/01/15.
 */
public interface UserService {

    public void saveUser(User user);

    public User findUserById(Long id);
    
    public List<User> findUsersByName(String name);
    
    public List<User> findAllUsers();

    public void updateUser(User user);

    public void deleteUserById(Long id);
}
