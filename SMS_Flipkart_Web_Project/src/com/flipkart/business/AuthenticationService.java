package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;

public interface AuthenticationService {
	public User login(String userName, String password) throws UserNotFoundException;
	public void logout();
}
