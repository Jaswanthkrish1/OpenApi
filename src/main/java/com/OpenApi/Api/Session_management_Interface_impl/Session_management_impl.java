package com.OpenApi.Api.Session_management_Interface_impl;

import java.util.Timer;
import java.util.TimerTask;


import org.springframework.stereotype.Service;

import com.OpenApi.Api.Payload.Utilize_user_dto;
import com.OpenApi.Api.Service_Interface.Session_Managemant_interface;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

@Service
public class Session_management_impl implements Session_Managemant_interface{
	
	
	
// don't try to make any changes in this file	
	
	
	//sessions start

	private static final long SESSION_TIMEOUT = 86400000; // 24 hours

	@Override
	public void startSession(HttpSession session, Utilize_user_dto login) {
		 Utilize_user_dto loggedInUser = (Utilize_user_dto) session.getAttribute("loggedInUser");
		    
		    if (loggedInUser != null) {
		        // User is already logged in, reuse the existing session ID
		        login.setId(session.getId());
		        System.out.println("Existing Session ID: " + session.getId());
		        session.setAttribute("loggedInUser", loggedInUser);
		        startSessionTimeout(session); // Start session timeout
		    } else {
		        // User is logging in for the first time, create a new session
		        login.setId(session.getId());
		        System.out.println("New Session ID: " + session.getId());
		        session.setAttribute("loggedInUser", login);
		        startSessionTimeout(session); // Start session timeout
		    }
		    
		    // Set the session ID as a cookie in the response
		    Cookie sessionCookie = new Cookie("sessionId", session.getId());
		    sessionCookie.setMaxAge((int) (SESSION_TIMEOUT / 1000)); // Convert milliseconds to seconds
		    sessionCookie.setPath("/");
		   
	}

	private void startSessionTimeout(HttpSession session) {
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	        @Override
	        public void run() {
	            if (session != null && !session.isNew()) {
	                endSession(session);
	            }
	            timer.cancel();
	        }
	    }, SESSION_TIMEOUT);
	}

	public void endSession(HttpSession session) {
	    session.removeAttribute("loggedInUser");
	    session.invalidate();
	}

//dont make ant changes in this
}
