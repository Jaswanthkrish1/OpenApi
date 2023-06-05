package com.OpenApi.Api.Service_Interface;

import org.springframework.http.ResponseEntity;

import com.OpenApi.Api.Entity.User_Api;
import com.OpenApi.Api.Payload.UserApi_dto;
import com.OpenApi.Api.ResponceModal.LoginResponceModal;


public interface UserApi_dto_interface {
	//client regAPI
    public ResponseEntity<String> userReg(String user,UserApi_dto reg);
    
    public ResponseEntity<LoginResponceModal> userLogin(String user,User_Api login);
}
