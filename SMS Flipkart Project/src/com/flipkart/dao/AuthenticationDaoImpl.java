/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.RegistrationNotApprovedByAdminException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtils;

/**
 * @author bhawesh
 *
 */
public class AuthenticationDaoImpl implements AuthenticationDao{
	private static Logger logger = Logger.getLogger(AuthenticationDaoImpl.class);
    private Connection connection = null;
    private PreparedStatement stmt = null;
    
	@Override
	public User login(String userName, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = null;
		try{
			
			connection = DBUtils.getConnection();
			stmt = connection.prepareStatement(SQLQueriesConstants.CHECK_USER_CREDENTIALS_QUERY);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			ResultSet result = stmt.executeQuery();
			while(result.next())
			{
				if(result.getInt("isApproved") == 0)
				{
					throw new RegistrationNotApprovedByAdminException();
				}
				else
				{
					stmt = connection.prepareStatement(SQLQueriesConstants.GET_USER_DETAILS);
					stmt.setString(1, userName);
					result.close();
					result = stmt.executeQuery();
					while(result.next()){
						user = new User();
						user.setEmailAddress(result.getString("emailAddress"));
						user.setFirstName(result.getString("firstName"));
						user.setLastName(result.getString("lastName"));
						user.setUserName(result.getString("userName"));
						user.setRole(result.getInt("role"));
						user.setUserID(result.getInt("userID"));
					}
					
				}
				
			}
			if(user == null)
			{
				throw new UserNotFoundException();
			}
			
		}
		catch(UserNotFoundException ex){
			logger.error(ex.getMessage());
		}
		catch(SQLException ex){
			logger.error(ex.getMessage());
		}
		catch(RegistrationNotApprovedByAdminException ex){
			logger.error(ex.getMessage());
		}
		catch(Exception ex){
			logger.error( ex.getMessage());
		}
		return user;
	}
	
	
	
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
}
