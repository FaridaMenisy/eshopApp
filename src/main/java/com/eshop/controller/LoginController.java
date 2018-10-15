package com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.model.Users;
import com.eshop.service.UserService;

@RestController
@RequestMapping(value="/log")
public class LoginController  {
	
@Autowired private UserService userService;

	@RequestMapping(value="/usercheck" ,method=RequestMethod.POST, consumes="application/json" , produces = "application/json" )
	public ResponseEntity<Users> checking (@RequestBody Users user ){
		
		String password = user.getPassword();
		String username = user.getUsername();
		Users  u = userService.validateUser(username, password);
		
		return  new ResponseEntity<Users>(u , HttpStatus.OK);
		//return  new ResponseEntity<String>("farida" , HttpStatus.OK);
	}
	
	 @RequestMapping(value="/user/", method=RequestMethod.GET, headers="Accept=application/json")
	 public @ResponseBody List getListUser(){
	  List users = userService.getListUser();
	  
	  return users;
	 }
	 
	 
	 @RequestMapping(value="/users/", method=RequestMethod.POST, headers="Accept=application/json")
	 public  String users (@RequestBody String username){
	 
	  
	  return username;
	 }

	
	
//	@RequestMapping(value="/checkUser" , method=RequestMethod.POST ,headers="Accept=application/json")
//	public ResponseEntity<String> check (@RequestBody String username  , String password){
//		
//		//Users user = userService.validateUser(username, password);
//		return  new ResponseEntity<String>(username , HttpStatus.OK);
//	}
	
	
	@RequestMapping(value="/check" ,method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> check (){
		
		
		//Users  u = userService.validateUser(username, password);
		
		return  new ResponseEntity<String>("heyyyyyyy" , HttpStatus.OK);
		//return  new ResponseEntity<String>("farida" , HttpStatus.OK);
	}
		
		
	}



