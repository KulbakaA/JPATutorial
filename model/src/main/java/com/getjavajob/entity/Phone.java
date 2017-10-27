package com.getjavajob.entity;

import com.getjavajob.entity.base.AbstractEntity;

public class Phone extends AbstractEntity {

	private String number;

	public Phone() {
	}

	public Phone(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Phone phone = (Phone) o;

		return number != null ? number.equals(phone.number) : phone.number == null;
	}

	@Override
	public int hashCode() {
		return number != null ? number.hashCode() : 0;
	}
}
