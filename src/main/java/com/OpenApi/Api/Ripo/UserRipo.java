package com.OpenApi.Api.Ripo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OpenApi.Api.Entity.User_Api;

public interface UserRipo extends JpaRepository<User_Api, Long> {
    
	public User_Api findByEmail(String email);
	public List<User_Api> findByUser(String email);
	public User_Api findByEmailAndPassword(String email,String password);
	public User_Api findByUserAndEmail(String email,String email2);
	public String deleteAllByUser(String email);
}
