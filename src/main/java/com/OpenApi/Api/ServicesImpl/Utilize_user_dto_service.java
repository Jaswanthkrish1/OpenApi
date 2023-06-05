package com.OpenApi.Api.ServicesImpl;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.OpenApi.Api.Entity.utilize_user;
import com.OpenApi.Api.Payload.Utilize_user_dto;
import com.OpenApi.Api.ResponceModal.Session_responce_model;
import com.OpenApi.Api.Ripo.utilizeIdentity;
import com.OpenApi.Api.Service_Interface.Utilize_user_dto_interface;
import java.util.concurrent.ScheduledExecutorService;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;
@Service
public class Utilize_user_dto_service implements Utilize_user_dto_interface {
 @Autowired
 private utilizeIdentity userRipo;
 
//sessions start
private int count=0;
private ScheduledExecutorService executorService;
 private static final long SESSION_TIMEOUT = 10000; // 10 seconds

 


//     this is for Register user from web app
	@Override
	public ResponseEntity<String> appReg(Utilize_user_dto reg) {
		if(userRipo.findByEmail(reg.getEmail())==null) {
			utilize_user newUser=utilizeDtoToUtilize_user(reg);
			userRipo.save(newUser);
			return ResponseEntity.status(HttpStatus.OK).body("User Added");
		}else {return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is Recored");}
		
		
	}
	public utilize_user utilizeDtoToUtilize_user(Utilize_user_dto user) {
		
			utilize_user add=new utilize_user();
			add.setEmail(user.getEmail());
			add.setPassword(user.getPassword());
			return add;
		
	}
//Server Login authentication
	@Override
	public ResponseEntity<Utilize_user_dto> appLogin( Utilize_user_dto login) {
		utilize_user email= userRipo.findByEmail(login.getEmail());
		
	    if (email!=null) {
	    
	        if (login.getPassword().equals(email.getPassword())) {
	        	
	        	 
	            return ResponseEntity.status(HttpStatus.OK).body(login);
	        } else {
	            
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(login);
	        }
	    } else {
	        
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(login);
	    }
	}
	
	@Override
	public Session_responce_model LoginCheck(Utilize_user_dto res) {
		utilize_user email= userRipo.findByEmail(res.getEmail());
		
		return null;
			
	}
	}

	

