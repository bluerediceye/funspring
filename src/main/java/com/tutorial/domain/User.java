package com.tutorial.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mli on 16/01/15.
 */

@Table(name = "USER")
@Entity
public class User implements Serializable{
    
    public static final String FIND_USERS_BY_NAME = "findUsersByName";

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;
    
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @JoinColumn(name = "GROUP_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
