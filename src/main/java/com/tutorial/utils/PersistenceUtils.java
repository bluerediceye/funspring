package com.tutorial.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created on 06/02/15
 *
 * @author Ming Li
 */
public class PersistenceUtils {

    private static EntityManagerFactory entityManagerFactory;

    public static SessionFactory getSessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    public static Session getCurrentSession() {
        return getSessionFactory().getCurrentSession();
    }

    public static Session getSession(EntityManager entityManager) {
        return entityManager.unwrap(Session.class);
    }

    public static EntityManager getEntityManager() {
        return EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerFactory);
    }

    private static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        PersistenceUtils.entityManagerFactory = entityManagerFactory;
    }
}
