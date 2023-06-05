package com.OpenApi.Api.Payload;

public class UserApi_dto {
	
	 private String email;
	 private String password;
	 private String username;
	 
	/**
	 * @param user
	 * @param email
	 * @param password
	 * @param username
	 */
	public UserApi_dto( String email, String password, String username) {
		super();
		
		this.email = email;
		this.password = password;
		this.username = username;
	}
	public UserApi_dto() {}
	
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
}
