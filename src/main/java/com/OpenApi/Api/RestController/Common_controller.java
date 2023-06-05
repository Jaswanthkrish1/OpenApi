package com.OpenApi.Api.RestController;




import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OpenApi.Api.Entity.Cookie_Session_Managent;
import com.OpenApi.Api.Entity.utilize_user;
import com.OpenApi.Api.Payload.Utilize_user_dto;
import com.OpenApi.Api.ResponceModal.Session_responce_model;
import com.OpenApi.Api.Ripo.Session_Ripo;
import com.OpenApi.Api.Ripo.utilizeIdentity;
import com.OpenApi.Api.Service_Interface.Utilize_user_dto_interface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

import java.util.concurrent.ScheduledExecutorService;
@RestController
public class Common_controller {
	@Autowired
	private Utilize_user_dto_interface utilizedtosevr;
	@Autowired
	 private utilizeIdentity userRipo;
	@Autowired
	private Session_Ripo CSM;
	private ScheduledExecutorService executorService;
	 private static final long SESSION_TIMEOUT = 10000; // 10 seconds
	String email="jaswanth@gmail.com";
	String password="jasw1";
	
	@PostMapping("/Login")
	public ResponseEntity<Session_responce_model> appLogin(@RequestBody Utilize_user_dto login, HttpSession session, HttpServletResponse response) {
	    utilize_user email = userRipo.findByEmail(login.getEmail());
	    if (email != null) {
	        System.out.println(email.getEmail());
	        if (email.getPassword().equals(login.getPassword())) {
	            System.out.println(email.getPassword());
	            Cookie_Session_Managent dataadd = CSM.findByEmailAndPassword(email.getEmail(), email.getPassword());
	            if (dataadd == null) {
	                String sessionID = session.getId();
	                Cookie_Session_Managent savetodb = userDetailsToCsm(email.getEmail(), email.getPassword(), sessionID);
	                savetodb = CSM.save(savetodb);
	                
	                // Set session attribute "LoggedIn"
	                session.setAttribute("LoggedIn", sessionID);
	                
	                // Set session timeout to 24 hours (in seconds)
	                session.setMaxInactiveInterval(24 * 60 * 60);
	                
	                // Set the session ID cookie with 24-hour expiration time
	                Cookie sessionCookie = new Cookie("sessionID", sessionID);
	                sessionCookie.setMaxAge(24 * 60 * 60);
	                sessionCookie.setPath("/");
	                response.addCookie(sessionCookie);
	                
	                return ResponseEntity.status(HttpStatus.OK).body(userresponce(email.getEmail(), sessionID));
	            } else {
	                return ResponseEntity.status(HttpStatus.OK).body(userresponce(email.getEmail(), dataadd.getSessionid()));
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	        }
	    }
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	}

	

	private Cookie_Session_Managent userDetailsToCsm(String email, String password, String sessionid) {
	    Cookie_Session_Managent add1 = new Cookie_Session_Managent();
	    add1.setEmail(email);
	    add1.setSessionid(sessionid);
	    add1.setPassword(password);
	    return add1;
	}

	private Session_responce_model userresponce(String email, String sessionid) {
	    Session_responce_model add1 = new Session_responce_model();
	    add1.setemail(email);
	    add1.setId(sessionid);
	    return add1;
	}
	
	
	// logout 
	
	@PostMapping("/{email}/Logout")
	@Transactional
	public ResponseEntity<String> appLogout(@PathVariable String email) {
	    // Check if the user is logged in
	    System.out.println(email);
	    Cookie_Session_Managent data = CSM.findByEmail(email);
	    if (data != null) {
	        CSM.deleteByEmail(email); // Use the deleteByEmail method from the repository
	        return ResponseEntity.status(HttpStatus.OK).body("Logout done");
	    } else {
	        return ResponseEntity.badRequest().body("User not logged in before");
	    }
	}


	}

	
	
	
	


