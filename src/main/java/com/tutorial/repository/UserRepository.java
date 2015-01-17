package com.tutorial.repository;

import com.tutorial.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by mli on 16/01/15.
 */

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addPerson(User user) {
        em.persist(user);
        em.flush();
    }
}
