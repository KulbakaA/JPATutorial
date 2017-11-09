package com.getjavajob.entity.valueobject;

import com.getjavajob.entity.base.AbstractEntity;
import com.getjavajob.entity.person.User;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="\"Group\"")
public class Group extends AbstractEntity {

    private String name;
    private String description;
    @OneToOne(mappedBy = "myGroup")
    private User creator;
    @ManyToMany(mappedBy = "groups")
    private Set<User> members = new HashSet<>();

    public Group() {
    }

    public Group(String name, String description, User creator, Set<User> members) {
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!name.equals(group.name)) return false;
        if (description != null ? !description.equals(group.description) : group.description != null) return false;
        if (creator != null ? !creator.equals(group.creator) : group.creator != null) return false;
        return members != null ? members.equals(group.members) : group.members == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (members != null ? members.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creator=" + creator +
                ", members=" + members +
                ", id=" + id +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
