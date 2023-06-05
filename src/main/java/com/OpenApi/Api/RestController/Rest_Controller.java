package com.OpenApi.Api.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenApi.Api.Entity.User_Api;
import com.OpenApi.Api.Payload.UserApi_dto;
import com.OpenApi.Api.Payload.Utilize_user_dto;
import com.OpenApi.Api.ResponceModal.LoginResponceModal;
import com.OpenApi.Api.ResponceModal.Session_responce_model;
import com.OpenApi.Api.Service_Interface.Session_Managemant_interface;
import com.OpenApi.Api.Service_Interface.UserApi_dto_interface;
import com.OpenApi.Api.Service_Interface.Utilize_user_dto_interface;
import com.OpenApi.Api.ServicesImpl.Utilize_user_dto_service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/reg")
public class Rest_Controller  {
	//session management
	@Autowired
	private Session_Managemant_interface sessionPoint;
	@Autowired
	private UserApi_dto_interface userdtoserv;
	@Autowired
	private Utilize_user_dto_interface utilizedtosevr;
	// client register
    @PostMapping("/{user}/reg/api")
	public ResponseEntity<String> userReg(@PathVariable String user,@RequestBody UserApi_dto userdto){
		return userdtoserv.userReg(user, userdto);
	}
    
  //client login
    @PostMapping("/{user}/login/api")
    public ResponseEntity<LoginResponceModal> userLogin2(@PathVariable String user,@RequestBody User_Api login){
    	return userdtoserv.userLogin(user, login);
    }
    //Server register
    @PostMapping("/App/Reg")
    public ResponseEntity<String> appReg(@RequestBody Utilize_user_dto userdto){
    	return utilizedtosevr.appReg(userdto);
    }
    //server login
    @PostMapping("/App/Login")
    public ResponseEntity<Utilize_user_dto> appLogin(@RequestBody Utilize_user_dto logindto) {
       
        return utilizedtosevr.appLogin(logindto);
    }
    
    //App logout
    @PostMapping("/App/Logout")
    public ResponseEntity<String> appLogout(HttpSession session) {
        // Invalidate the session to logout the user
    	
    	// utilizedtosevr.endSession(session);
        return ResponseEntity.ok("Logged out successfully");
    }
    
}
