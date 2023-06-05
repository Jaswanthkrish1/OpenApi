package com.OpenApi.Api.Service_Interface;

import com.OpenApi.Api.Payload.Utilize_user_dto;

import jakarta.servlet.http.HttpSession;

public interface Session_Managemant_interface {
	 public void startSession(HttpSession session, Utilize_user_dto login);
	  public void endSession(HttpSession session);
}
