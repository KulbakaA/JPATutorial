package com.getjavajob.entity.valueobject;

import com.getjavajob.entity.base.AbstractEntity;
import com.getjavajob.entity.person.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone extends AbstractEntity {

    private String number;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Phone() {
    }

    public Phone(String number, User owner) {
        this.number = number;
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (number != null ? !number.equals(phone.number) : phone.number != null) return false;
        return owner != null ? owner.equals(phone.owner) : phone.owner == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", owner=" + owner +
                ", id=" + id +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
