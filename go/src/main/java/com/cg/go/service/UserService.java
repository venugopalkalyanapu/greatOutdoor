package com.cg.go.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.dao.UserDAOInterface;
import com.cg.go.entity.UserEntity;
import com.cg.go.exception.IdNotFoundException;
import com.cg.go.exception.UserNotFoundException;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	private UserDAOInterface ud;

	@Override
	public UserEntity AddUser(UserEntity u,String ss)throws UserNotFoundException  {
		UserEntity u1=new UserEntity();
		u1.setUserType(ss);
		if(!u1.getUserType().equalsIgnoreCase("admin") &  !u1.getUserType().equalsIgnoreCase("customer"))
			throw new UserNotFoundException("invalid user type");
	   return ud.save(u);
	}

	@Override
	public String loginUser(UserEntity s) throws IdNotFoundException {
		String userId = s.getUserId();
		String userPassword = s.getUserPassword();
		 Optional<UserEntity> a = ud.findById(userId);
		 UserEntity q = a.get();
		 if(!q.getUserId().equalsIgnoreCase(userId) || !q.getUserPassword().equalsIgnoreCase(userPassword)) { 
			   throw new IdNotFoundException("Id not found");
			   }
		 return "login successfully";
		 
	}

	@Override
	public String logoutUser() {
		
		return "logout successfully";
	}
}
