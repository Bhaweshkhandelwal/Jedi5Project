/**
 * 
 */
package com.flipkart.business;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.dao.AuthenticationDao;
import com.flipkart.dao.AuthenticationDaoImpl;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author bhawesh
 *
 */
public class AuthenticationServiceImpl implements AuthenticationService {

	
	 private static Logger logger = Logger.getLogger(AuthenticationServiceImpl.class);
	 private static AuthenticationDao authenticationDao = new AuthenticationDaoImpl();
	
	 /*
	  * (non-Javadoc)
	  * @see com.flipkart.business.AuthenticationService#logout()
	  * This is method to logout .
	  */
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.AuthenticationService#login(java.lang.String, java.lang.String)
	 * This is a login method and returns user on successful login and null on failure.
	 */
	@Override
	public User login(String userName, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = authenticationDao.login(userName, password);
		return user;
	}

}
