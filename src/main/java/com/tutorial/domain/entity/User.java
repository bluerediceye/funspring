package com.tutorial.domain.entity;

import javax.persistence.*;

/**
 * Created by mli on 16/01/15.
 */

@Table(name = "USERS")
@Entity
public class User extends BaseEntity {
    
    @Column(name = "USER_NAME", length = 50, unique = true,  nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @JoinColumn(name = "GROUP_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;
    
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;
    
    @OneToOne
    @JoinColumn(name = "FK_USER_DETAILS_ID", unique = true)
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
