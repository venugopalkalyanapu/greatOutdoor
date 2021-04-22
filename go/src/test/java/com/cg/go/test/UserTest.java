package com.cg.go.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.go.dao.UserDAOInterface;
import com.cg.go.entity.UserEntity;
import com.cg.go.exception.IdNotFoundException;
import com.cg.go.exception.UserNotFoundException;
import com.cg.go.service.UserService;

@SpringBootTest
class testUser {

	@Autowired
	private UserService us;

	@MockBean
	private UserDAOInterface udi;


	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws UserNotFoundException {
		System.out.println("Clean up complete");
	}
	
	// Test Method for Add user
	@Test 
	void testAdduser() throws UserNotFoundException{ 
		UserEntity u1 = new UserEntity("sai", "5","customer", "456"); 
		when(udi.save(u1)).thenReturn(u1);
		assertEquals(u1, us.AddUser(u1, "customer"));
	}
	
	//Test Method for login
	@Test
	void testLogin() throws IdNotFoundException {
		UserEntity user = new UserEntity("sai", "5","customer", "456");
		Optional<UserEntity> op = Optional.of(user);
		when(udi.findById(user.getUserId())).thenReturn(op);
		String actualUser = us.loginUser(user);
		assertEquals("login successfully", actualUser);
	}
	
	//Test Method for logout
	@Test
	void testLogout() {
		String actualUser = us.logoutUser();
		assertEquals("logout successfully",actualUser);
	}
}
