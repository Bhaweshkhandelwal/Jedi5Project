/**
 * 
 */
package com.flipkart.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceImpl;
import com.flipkart.business.UserService;
import com.flipkart.business.UserServiceImpl;

/**
 * @author bhawesh
 *
 */
@Path(value="/admin")
public class AdminController {
	
	
	AdminService adminService = new AdminServiceImpl();
	UserService userService = new UserServiceImpl();
	 
	boolean result;
	
	/*
	 * This method is for testing the conversion to JSON object
	 */
	@GET
	@Path(value="/getUser")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(){
		User user = new User();
		user.setEmailAddress("xyz.gmail.com");
		user.setFirstName("xyz");
		user.setLastName("xyz");
		user.setRole(1);
		user.setUserName("xyz");
		return user;
	}
	
	
	/*
	 * This method is for testing the conversion to JSON object
	 */
	@GET
	@Path(value="/getCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourse(){
		Course course = new Course();
		course.setCourseDescription("courseDescription");
		course.setCourseID(1);
		course.setCourseName("courseName");
		return course;
	}
	
	
	/*
	 * Method for adding a new user.
	 */
	@POST
	@Path("/addUser")
	@Produces("application/JSON")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user){
		
        result = adminService.addUser(user);
        String response="User is successfully added.";
        if(result == true){
        	return Response.status(201).entity(response).build();
        }
        	response = "User could not be added.";
        	return Response.status(201).entity(response).build();
        
	}
	
	
	/*
	 * Method for deleting a user.
	 */
	@DELETE
	@Path("/deleteUser/{userName}")
	public Response deleteUser(@PathParam("userName") String userName){

		result = adminService.deleteUser(userName);
		if(result == true)
		{
			return Response.status(200).entity("User with userName " +userName + " is successfully deleted").build();
		}
		else
		{
			return Response.status(200).entity("User with userName " +userName + " could not be deleted").build();
		}
		
	}
	
	
	/*
	 * Method for viewing a list of all courses.
	 */
	@GET
	@Path("/viewCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> viewCourses()
	{
		ArrayList<Course> courseList = userService.viewCourses();
		return courseList;
	}
	
	
	/*
	 * Method for adding a course.
	 */
	@POST
	@Path("/addCourse")
	@Produces("application/JSON")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCourse(Course course){
		
        result = adminService.addCourse(course);
        if(result == true){
        	return Response.status(201).entity("Course "  +course.getCourseName() + " is successfully added." ).build();
        }else{
        	return Response.status(201).entity("Course "  +course.getCourseName() + " could not be added." ).build();
        }
        	
		
	}
	
	/*
	 * Method for deleting a course.
	 */
	@DELETE
	@Path("/deleteCourse/{courseID}")
	public Response deleteCourse(@PathParam("courseID") int courseID){
		
		result = adminService.deleteCourse(courseID);
		if(result == true){
        	return Response.status(200).entity("Course with courseID "  + courseID + " is successfully deleted." ).build();
        }else{
        	return Response.status(200).entity("Course with courseID "  + courseID + " is successfully deleted." ).build();
        }
		
	}
	
	
	/*
	 * Method for approving user registration
	 */
	@PUT
	@Path("/approveUserRegistration")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response approveUserRegistration(String userName){
		
		result=adminService.approveUserRegistration(userName);
		
		if(result == true){
        	return Response.status(200).entity("Registration of user with userName "  + userName + " is successfully approved." ).build();
        }else{
        	return Response.status(200).entity("Registration of user with userName "  + userName + " could not be approved." ).build();
        }
		
	}
	
}
