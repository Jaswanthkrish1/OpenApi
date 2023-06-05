package com.OpenApi.Api.ResponceModal;

public class Session_responce_model {
 private String username;
 private String email;
 private String id;
 private int count;
 


public Session_responce_model(String username, String email, String id,int count) {
	super();
	this.username = username;
	this.email = email;
	this.id = id;
	this.count=count;
}

public Session_responce_model() {
	super();
	// TODO Auto-generated constructor stub
}
 
public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getemail() {
	return email;
}
public void setemail(String email) {
	this.email = email;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
 
}
