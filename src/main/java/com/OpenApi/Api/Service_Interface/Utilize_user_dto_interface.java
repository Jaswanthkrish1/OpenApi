package com.OpenApi.Api.Service_Interface;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.OpenApi.Api.Payload.Utilize_user_dto;
import com.OpenApi.Api.ResponceModal.Session_responce_model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;


public interface Utilize_user_dto_interface {
//	server register methods
  public  ResponseEntity<String> appReg(Utilize_user_dto reg);
  
  public ResponseEntity<Utilize_user_dto> appLogin(Utilize_user_dto login);
  
  public Session_responce_model LoginCheck(Utilize_user_dto res);
  
}
