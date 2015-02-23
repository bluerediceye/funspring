package com.tutorial.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created on 26/01/15
 *
 * @author Ming Li
 */
@XmlRootElement
@Table(name = "USERS")
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "user")
public class User extends BaseEntity {

    @Column(name = "USERNAME", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_GROUP_ID")
    private Group group;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_USER_DETAILS_ID", unique = true, nullable = true)
    private UserDetails userDetails;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
