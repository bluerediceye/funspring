package com.tutorial.service;

import com.tutorial.application.Auditable;
import com.tutorial.domain.entity.User;
import com.tutorial.repository.UserJpaRepository;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created on 18/01/15
 *
 * @author Ming Li
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private Validator validator;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    @Auditable("smaller")
    public void saveUser(User user) {
        entityManager.unwrap(Session.class);
        LOG.info("Save user into database.");
        userJpaRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userJpaRepository.findOne(id);
    }

    @Override
    public List<User> findUsersByName(String name) {
        return userJpaRepository.findUsersByName(name);
    }

    @Override
    public List<User> findAllUsers() {
        return userJpaRepository.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userJpaRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userJpaRepository.delete(id);
    }

    protected Validator getValidator() {
        return validator;
    }

    protected void setValidator(Validator validator) {
        this.validator = validator;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
