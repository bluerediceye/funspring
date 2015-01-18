package com.tutorial.repository;

import com.tutorial.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by mli on 18/01/15.
 */

@Repository(value = "userRepository")
public class UserRepositoryImpl implements CustomUserRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<User> findUsersByName() {
        return null;
    }
}
