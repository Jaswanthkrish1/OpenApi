package com.OpenApi.Api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class utilize_user {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String email;
private String password;

/**
 * @param id
 * @param email
 * @param password
 */
public utilize_user(long id, String email, String password) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
}
public utilize_user() {}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
