package com.tutorial.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;

/**
 * Created by mli on 27/01/15.
 */
@Entity
@Table(name = "USER_DETAILS" )
public class UserDetails extends BaseEntity {
    
    @OneToOne(mappedBy = "userDetails")
    private User user;
    
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 50, nullable = true)
    private String middleName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Transient
    private String fullName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Past
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private LocalDate dateOfBirth;

    @Transient
    private int age;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
