package com.cg.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.entity.UserEntity;
import com.cg.go.exception.UserNotFoundException;
import com.cg.go.service.UserServiceInterface;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceInterface us;
	
	@PostMapping("AddUser/{usertype}")
	public UserEntity AddUser(@RequestBody UserEntity u,@PathVariable("usertype") String ss)throws UserNotFoundException {
		/*
		 * UserEntity u1=new UserEntity(); u1.setUserType(ss);
		 * if(!u1.getUserType().equalsIgnoreCase("admin") &
		 * !u1.getUserType().equalsIgnoreCase("customer")) throw new
		 * UserNotFoundException("invalid user type");
		 */
		UserEntity uu=us.AddUser(u,ss);
		return uu;
	}
   @GetMapping("login/{uid}/{password}")
   public String loginUser(@PathVariable("uid") String s, @PathVariable("password") String k) {
	   UserEntity e = new UserEntity();
	   e.setUserId(s);
	   e.setUserPassword(k);
	return us.loginUser(e);
	  
   }
   @GetMapping("logout")
   public String logoutUser() {
	   return us.logoutUser();
   }
}