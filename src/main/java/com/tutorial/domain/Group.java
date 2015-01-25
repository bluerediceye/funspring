package com.tutorial.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mli on 20/01/15.
 */
@Entity
@Table(name = "GROUPS")
public class Group extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
