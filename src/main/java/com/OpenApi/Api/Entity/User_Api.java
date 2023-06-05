package com.OpenApi.Api.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table
@Entity
public class User_Api {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
	
    @Column(name = "user_id")
 private String user;


private String email;
 private String password;
 private String username;
public User_Api(long id, String email, String password, String username ,String user) {
	super();
	this.id = id;
	this.user=user;
	this.email = email;
	this.password = password;
	this.username = username;
}
public User_Api() {}

public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}

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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Override
public String toString() {
	return "User_Api [id=" + id + ", user=" + user + ", email=" + email + ", password=" + password + ", username="
			+ username + "]";
}
@Override
public int hashCode() {
	return Objects.hash(email, password);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User_Api other = (User_Api) obj;
	return Objects.equals(email, other.email) && Objects.equals(password, other.password);
}



 
}
