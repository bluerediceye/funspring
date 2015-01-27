package com.tutorial.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;

/**
 * Created by mli on 16/01/15.
 */

@Table(name = "USERS")
@Entity
public class User extends BaseEntity {
    
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 50, nullable = true)
    private String middleName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;
    
    @Column(name = "USER_NAME", length = 50, unique = true,  nullable = false)
    private String username;
    
    @Transient
    private String fullName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Past
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private LocalDate dateOfBirth;

    @Transient
    private int age;

    @JoinColumn(name = "GROUP_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;
    
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;
    
    public User() {
    }

    public User(String username, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @PostLoad
    @PreUpdate
    @PrePersist
    private void prepare(){
        calculateAge();
        calculateFullName();
    }
    
    private void calculateAge() {
        this.age = new LocalDate().getYear() - this.dateOfBirth.getYear();
    }

    private void calculateFullName() {
        String middle = StringUtils.isEmpty(middleName) ? 
                StringUtils.SPACE 
                : 
                StringUtils.SPACE + middleName.trim() + StringUtils.SPACE; 
        this.fullName = firstName.trim() + middle + lastName.trim();
    }
}
