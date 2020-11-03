/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author bhawesh
 *
 */
public interface AuthenticationDao {
	public User login(String userName, String password) throws UserNotFoundException;
	public void logout();
}
