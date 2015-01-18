package com.tutorial.repository;

import com.tutorial.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by mli on 18/01/15.
 */
@Repository
public class UserRepositoryImpl implements CustomUserRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findUsersByName(String name) {
        Query query =  entityManager.createQuery("select user from User user where user.name = :username");
        query.setParameter("username", name);
        return (List<User>) query.getResultList();
    }
}
