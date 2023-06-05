package com.OpenApi.Api.Payload;

public class Utilize_user_dto {

	private String email;
	private String password;
	private String id;
	
	
	
	/**
	 * @param email
	 * @param password
	 * @param id
	 */
	public Utilize_user_dto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		
	}

	/**
	 * @param id
	 */
	public Utilize_user_dto(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Utilize_user_dto() {}
	
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
