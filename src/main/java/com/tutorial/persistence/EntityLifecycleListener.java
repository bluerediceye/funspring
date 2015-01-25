package com.tutorial.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/**
 * Created by mli on 25/01/15.
 */
public class EntityLifecycleListener {
    
    private Logger  LOG = LoggerFactory.getLogger(EntityLifecycleListener.class);
    
    @PrePersist
    void prePersist(Object object){
        LOG.info("------------prePersist()");
    }
    
    @PostPersist
    void postPersist(Object object){
        LOG.info("------------postPersist()");
    }

    @PreUpdate
    void preUpdate(Object object){
        LOG.info("------------prePersist()");
    }

    @PostUpdate
    void postUpdate(Object object){
        LOG.info("------------postPersist()");
    }

    @PreRemove
    void preRemove(Object object){
        LOG.info("------------prePersist()");
    }

    @PostRemove
    void postRemove(Object object){
        LOG.info("------------postPersist()");
    }
    
    @PostLoad
    void postLoad(Object object){
        LOG.info("------------postLoad()");
    }
}
