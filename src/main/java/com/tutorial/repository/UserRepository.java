package com.tutorial.repository;

import com.tutorial.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mli on 16/01/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user from User user where user.name = :name")
    public List<User> findUsersByName(@Param("name") String name);
}
