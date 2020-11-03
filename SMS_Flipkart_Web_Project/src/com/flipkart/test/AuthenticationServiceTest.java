package com.flipkart.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.flipkart.bean.User;
import com.flipkart.business.AuthenticationService;
import com.flipkart.business.AuthenticationServiceImpl;
import com.flipkart.exception.UserNotFoundException;

public class AuthenticationServiceTest {

//	 authenticationService;
	 AuthenticationService authenticationService;
	@Before
	public void setUp() throws Exception {
		authenticationService = new AuthenticationServiceImpl();
	}

	@Test
	public void testLogin() throws UserNotFoundException {
		User user = authenticationService.login("amitBalyan","user123");
		assertNotNull(user);
	}

}
