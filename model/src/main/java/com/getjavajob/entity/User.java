package com.getjavajob.entity;

import com.getjavajob.entity.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Collections;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    private String name;
    private String lastName;
    @Column(nullable = false,unique = true,length = 32)
    private String email;
    private List<Phone> listOfPhones;
    private List<User> friends;
    private Gender gender;

    public User() {
    }

    public User(final String name, final String lastName, String email,
                final List<Phone> listOfPhones,
                final List<User> friends,
                final Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.listOfPhones = listOfPhones;
        this.friends = friends;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Phone> getListOfPhones() {
        return Collections.unmodifiableList(this.listOfPhones);
    }

    public void setListOfPhones(List<Phone> listOfPhones) {
        this.listOfPhones = listOfPhones;
    }

    public List<User> getFriends() {
        return Collections.unmodifiableList(this.friends);
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
