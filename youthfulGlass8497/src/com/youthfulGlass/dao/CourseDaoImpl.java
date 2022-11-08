package com.youthfulGlass.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.model.Course;
import com.youthfulGlass.utility.DBAUtility;

public class CourseDaoImpl implements CourseDao{

	@Override
	public String addCourse(Course course)throws CourseException {
		String message = "Not Inserted...!";
		
		try(Connection conn = DBAUtility.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?,?)");
			
			ps.setInt(1, course.getCourse_id());
			ps.setString(2, course.getCourse_name());
			ps.setInt(3, course.getTotal_seat());
			ps.setInt(4, course.getCoursefee());
			ps.setInt(5, course.getremaining_seats());
			
			int x = ps.executeUpdate();
			
			
			if(x>0) {
				message = "course data inserted Successfully...!";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return message;
		
	}

}
