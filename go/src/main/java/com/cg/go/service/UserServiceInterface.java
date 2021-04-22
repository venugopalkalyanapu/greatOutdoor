package com.cg.go.service;

import com.cg.go.entity.UserEntity;
import com.cg.go.exception.UserNotFoundException;

public interface UserServiceInterface {
	public UserEntity AddUser(UserEntity u,String ss)throws UserNotFoundException ;

	public String loginUser(UserEntity s);

	public String logoutUser();
	

}
