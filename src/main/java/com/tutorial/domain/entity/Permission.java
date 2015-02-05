package com.tutorial.domain.entity;

import javax.persistence.*;

/**
 * Created on 28/01/15
 *
 * @author Ming Li
 */
@Entity
@Table(name = "PERMISSIONS", indexes = {
        @Index(columnList = "USERNAME,PERMISSION,TARGET", unique = true)
})
public class Permission extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    private User user;

    @Column(name = "PERMISSION")
    private String permission;
    @Column(name = "TARGET")
    private String target;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
