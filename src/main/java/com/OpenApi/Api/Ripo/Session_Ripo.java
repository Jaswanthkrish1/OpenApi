package com.OpenApi.Api.Ripo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.OpenApi.Api.Entity.Cookie_Session_Managent;
import com.OpenApi.Api.Payload.Utilize_user_dto;
import com.OpenApi.Api.ResponceModal.Session_responce_model;

import jakarta.persistence.EntityManager;

public interface Session_Ripo extends JpaRepository<Cookie_Session_Managent, Long>{
	public Cookie_Session_Managent findByEmailAndPassword(String username,String password) ;
	public Cookie_Session_Managent findByEmail(String email);
	public void deleteByEmail(String email);

}
