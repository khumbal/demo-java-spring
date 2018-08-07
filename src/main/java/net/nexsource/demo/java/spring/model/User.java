package net.nexsource.demo.java.spring.model;

import net.nexsource.demo.java.spring.model.base.BaseEntity;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import java.io.Serializable;

public class User extends BaseEntity {

	// form:input - textbox
	String name;

	// form:input - textbox
	String email;

	// form:textarea - textarea
	String address;

	// form:input - password
	String password;

	// form:input - password
	String confirmPassword;

	//Check if this is for New of Update
	public boolean isNew() {
		return (this.getId() == null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}