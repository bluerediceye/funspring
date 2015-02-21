package com.tutorial.repository;

import com.tutorial.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query("select user from User user where user.username = :username")
    public List<User> findUsersByName(@Param("username") String username);
}
