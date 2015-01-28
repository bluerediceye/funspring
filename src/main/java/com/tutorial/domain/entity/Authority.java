package com.tutorial.domain.entity;

import javax.persistence.*;

/**
 *
 * Created on 26/01/15
 * @author Ming Li
 */
@Entity
@Table(name = "AUTHORITIES")
public class Authority extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME", unique = false, referencedColumnName = "USERNAME")
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
