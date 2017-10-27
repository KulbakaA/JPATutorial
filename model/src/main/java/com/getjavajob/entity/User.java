package com.getjavajob.entity;

import com.getjavajob.entity.base.AbstractEntity;

import java.util.Collections;
import java.util.List;

public class User extends AbstractEntity {

	private String name;
	private String lastName;
	private List<Phone> listOfPhones;
	private List<User> friends;
	private Gender gender;

	public User() {
	}

	public User(final String name,final String lastName,
				final List<Phone> listOfPhones,
				final List<User> friends,
				final Gender gender) {
		this.name = name;
		this.lastName = lastName;
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

	public List<Phone> getListOfPhones() {
		return Collections.unmodifiableList(this.listOfPhones);
	}

	public void setListOfPhones(List<Phone> listOfPhones) {
		this.listOfPhones = listOfPhones;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
		return listOfPhones != null ? listOfPhones.equals(user.listOfPhones) : user.listOfPhones == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (listOfPhones != null ? listOfPhones.hashCode() : 0);
		return result;
	}
}
