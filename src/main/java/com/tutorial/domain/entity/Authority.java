package com.tutorial.domain.entity;

import javax.persistence.*;

/**
 * Created by mli on 26/01/15.
 */
@Entity
@Table(name = "AUTHORITIES")
public class Authority extends BaseEntity{
    
    @OneToOne
    @JoinColumn(name = "USER_NAME", unique = true, referencedColumnName = "USER_NAME")
    private User user;

    @Column(name = "AUTHORITY", length = 50, nullable = false)
    private String authority;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    
    
}
