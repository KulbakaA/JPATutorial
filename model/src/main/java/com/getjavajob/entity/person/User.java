package com.getjavajob.entity.person;

import com.getjavajob.entity.base.AbstractEntity;
import com.getjavajob.entity.valueobject.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends AbstractEntity {

    private String name;
    private String lastName;
    @Column(nullable = false, unique = true, length = 32)
    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Phone> listOfPhones;
    @Transient
    private List<User> friends;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Rrole rrole;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Group myGroup;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_group",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private Set<Group> groups = new HashSet<>();


    public User() {
    }

    public User(final String name, final String lastName, String email,
                final List<Phone> listOfPhones,
                final List<User> friends,
                final Gender gender,
                final Role role,
                final Rrole rrole,
                final Group myGroup) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.listOfPhones = listOfPhones;
        this.friends = friends;
        this.gender = gender;
        this.role = role;
        this.rrole = rrole;
        this.myGroup = myGroup;
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
        if (this.listOfPhones == null) {
            this.listOfPhones = new ArrayList<>();
        }
        return this.listOfPhones;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Rrole getRrole() {
        return rrole;
    }

    public void setRrole(Rrole rrole) {
        this.rrole = rrole;
    }

    public Group getMyGroup() {
        return myGroup;
    }

    public void setMyGroup(Group myGroup) {
        this.myGroup = myGroup;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", listOfPhones=" + listOfPhones +
                ", friends=" + friends +
                ", gender=" + gender +
                ", role=" + role +
                ", rrole=" + rrole +
                ", myGroup=" + myGroup +
                ", groups=" + groups +
                ", id=" + id +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (!email.equals(user.email)) return false;
        if (listOfPhones != null ? !listOfPhones.equals(user.listOfPhones) : user.listOfPhones != null) return false;
        if (friends != null ? !friends.equals(user.friends) : user.friends != null) return false;
        if (gender != user.gender) return false;
        if (role != user.role) return false;
        if (rrole != null ? !rrole.equals(user.rrole) : user.rrole != null) return false;
        if (myGroup != null ? !myGroup.equals(user.myGroup) : user.myGroup != null) return false;
        return groups != null ? groups.equals(user.groups) : user.groups == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + email.hashCode();
        result = 31 * result + (listOfPhones != null ? listOfPhones.hashCode() : 0);
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (rrole != null ? rrole.hashCode() : 0);
        result = 31 * result + (myGroup != null ? myGroup.hashCode() : 0);
        result = 31 * result + (groups != null ? groups.hashCode() : 0);
        return result;
    }
}
