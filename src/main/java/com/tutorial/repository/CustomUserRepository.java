package com.tutorial.repository;

import com.tutorial.domain.User;

import java.util.List;

/**
 * Created by mli on 18/01/15.
 */
public interface CustomUserRepository {

    public List<User> findUsersByName(String name);
}
