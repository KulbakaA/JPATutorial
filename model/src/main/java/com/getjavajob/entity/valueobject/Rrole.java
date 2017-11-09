package com.getjavajob.entity.valueobject;

import com.getjavajob.entity.base.AbstractEntity;
import com.getjavajob.entity.person.User;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rrole extends AbstractEntity{

    private String title;
    @OneToMany(mappedBy = "rrole")
    private Set<User> users = new HashSet<>();


    public Rrole() {
    }

    public Rrole(String title, Set<User> users) {
        this.title = title;
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
