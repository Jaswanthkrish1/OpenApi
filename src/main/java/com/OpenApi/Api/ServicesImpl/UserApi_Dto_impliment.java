package com.OpenApi.Api.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.OpenApi.Api.Entity.User_Api;
import com.OpenApi.Api.Entity.utilize_user;
import com.OpenApi.Api.Payload.UserApi_dto;
import com.OpenApi.Api.ResponceModal.LoginResponceModal;
import com.OpenApi.Api.Ripo.UserRipo;
import com.OpenApi.Api.Ripo.utilizeIdentity;
import com.OpenApi.Api.Service_Interface.UserApi_dto_interface;
@Service
public class UserApi_Dto_impliment implements UserApi_dto_interface{
    @Autowired
    private UserRipo userripo;
    @Autowired
    private utilizeIdentity utilizeripo;
	
    //Client api like user will register with this api 
    @Override
	public ResponseEntity<String> userReg(String user,UserApi_dto reg) {
		  utilize_user access=utilizeripo.findByEmail(user);
    	  List<User_Api> existing=userripo.findByUser(user);
    	  int count=existing.size();
    	  if(access!=null) {
    	  if( count <=5) {
    		  User_Api data = userripo.findByUserAndEmail(user, reg.getEmail());
    		  if(data==null) {
    		  User_Api userReg=dtoToUser_Api(user, reg);
    		  userripo.save(userReg);
    		  return ResponseEntity.ok("Register done");
    	  }else {
    		  String errorMsg = "User with the provided email already exists.";
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);}
    	  }else {
    		  userripo.deleteAll(existing);
 	         String errorMsg = "Maximum limit exceeded. Existing registrations have been deleted.";
 	         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
    		  }
    	  }else {
    		  String errorMsg = "User not found. Your Not Register";
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
    	  }
		
	}
      public User_Api dtoToUser_Api(String user,UserApi_dto reg) {
    	  
    		  User_Api add=new User_Api();
    		  add.setEmail(reg.getEmail());
    		  add.setPassword(reg.getPassword());
    		  add.setUser(user);
    		  add.setUsername(reg.getUsername());
    		  return add;
    	  
      }
   
      
      //UserLogin client
	@Override
	public ResponseEntity<LoginResponceModal > userLogin(String user,User_Api login){
		User_Api clintuser=userripo.findByUserAndEmail(user,login.getEmail());
		
		LoginResponceModal add=new LoginResponceModal();
		add.setEmail(login.getEmail());
		add.setUsername(login.getPassword());
		
		if(clintuser!=null) {
			
			if(clintuser.getPassword().equals(login.getPassword()))
			{
				LoginResponceModal add2=new LoginResponceModal();
				add2.setEmail(login.getEmail());
				add2.setUsername(clintuser.getUsername());
				return ResponseEntity.ok().body(add2);
			}else {return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(add);}
		
	}else {return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(add);}
		
	}
      
	
}
