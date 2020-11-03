/**
 * 
 */
package com.flipkart.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipkart.bean.Login;
import com.flipkart.bean.User;
import com.flipkart.business.AuthenticationService;
import com.flipkart.business.AuthenticationServiceImpl;
import com.flipkart.business.UserService;
import com.flipkart.business.UserServiceImpl;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author bhawesh
 *
 */
@Path(value="/user")
public class UserController {
	
	AuthenticationService authenticationService = new AuthenticationServiceImpl();
	UserService userService = new UserServiceImpl();
	Logger logger = Logger.getLogger(UserController.class);
	User user = null;
	
	
	/*
	 * This method is just to test the flow.
	 */
	
	@GET
	@Path(value="/hello")
	public String test()
	{
		return "This is to test the rest";
	}
	
	
	/*
	 * This method is to login
	 * It will return the user of the respective type(Admin, Professor, Student).
	 */
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/JSON")
	public Response login(Login login) throws UserNotFoundException {
		User user = authenticationService.login(login.getUserName(), login.getPassword());
		return Response.status(201).entity(user).build();
	}
	
	
	/*
	 * This method is to register a new user.
	 * It will return a boolean value which represents whether the registration is successfull.
	 */
	@POST
	@Path("/register")
	@Produces("application/JSON")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(User user){
		
		boolean registrationStatus = userService.registerUser(user);
		if(registrationStatus == true){
			return Response.status(201).entity("User " + user.getUserName() + "has been successfully registered").build();
		}else{
			return Response.status(201).entity("User " + user.getUserName() + "could not register.").build();
		}
	}
}
