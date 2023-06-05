package com.OpenApi.Api.Entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cookie_Session_Managent {
private String password;
private String username;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String sessionid;
private String email;



/**
 * @param password
 * @param username
 * @param id
 * @param sessionid
 * @param email
 */
public Cookie_Session_Managent(String password, String username, long id, String sessionid, String email) {
	super();
	this.password = password;
	this.username = username;
	this.id = id;
	this.sessionid = sessionid;
	this.email = email;
}
public Cookie_Session_Managent() {}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getSessionid() {
	return sessionid;
}
public void setSessionid(String sessionid) {
	this.sessionid = sessionid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
