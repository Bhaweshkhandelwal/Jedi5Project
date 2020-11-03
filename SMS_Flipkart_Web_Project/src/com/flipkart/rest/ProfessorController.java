/**
 * 
 */
package com.flipkart.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.business.ProfessorService;
import com.flipkart.business.ProfessorServiceImpl;

/**
 * @author bhawesh
 *
 */
@Path(value="/professor")
public class ProfessorController {
	
	ProfessorService professorService = new ProfessorServiceImpl();
	Logger logger = Logger.getLogger(ProfessorController.class);
	
	/*
	 * Method to record a grade.
	 * It will return a boolean value which represents whether a grade is successfully recorded or not.
	 */
	@PUT
	@Path("/recordGrade")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recordGrade(Grade grade){
		
		boolean result=professorService.recordGrade(grade.getCourseID(), grade.getStudentID(), grade.getGrade());
		if(result == true){
			return Response.status(200).entity("Grade has been successfully recorded." ).build();
		}else{
			return Response.status(200).entity("Grade could not be recorded." ).build();
		}
			
		
	}
	
	/*
	 * Method to view list of all students that are studying a particular course.
	 * It will return list of all students that are enrolled in the respective course.
	 */
	@GET
	@Path("/viewStudentList/{courseID}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Student> viewStudentList(@PathParam("courseID") int courseID)
	{
		ArrayList<Student> studentList = professorService.viewStudentList(courseID);
		logger.info("Printing the studentList: ");
		return studentList;
	}
	
	
	/*
	 * Method to view details of a particular course.
	 * It will return the course with the respective courseID.
	 */
	@GET
	@Path("viewCourse/{courseID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course viewCourse(@PathParam("courseID") int courseID)
	{
		Course course = professorService.viewCourse(courseID);
		return course;
	}
	
	
}
