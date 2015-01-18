package com.tutorial.domain;

import javax.persistence.*;

/**
 * Created by mli on 16/01/15.
 */

@Table(name = "USER")
@Entity
public class User {

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
