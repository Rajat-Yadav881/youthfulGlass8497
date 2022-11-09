package com.youthfulGlass.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	@Override
	public String updateFee(int course_id, int course_fee) throws CourseException {
		String message = "fee not updated...!";
		
		try(Connection conn = DBAUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update course set course_fee = ? where course_id = ?");
			ps.setInt(1, course_fee);
			ps.setInt(2, course_id);
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "the fee data is updated Successfully...!";
			}
		}catch(SQLException e) {
			e.getMessage();
			throw new CourseException("the fee is updated...");
		}
		
		return message;
	}

	@Override
	public String deleteCourse(int course_id) throws CourseException {
		String message = "data not deleted...!";
		
		try(Connection conn = DBAUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("delete from course where course_id = ?");
			
			ps.setInt(1, course_id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "the data is deleted Successfully...!";
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public Course getDetailsCourse(int course_id) throws CourseException {
		Course course = null;
		
		
		try (Connection conn = DBAUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from course where course_id = ?");
			ps.setInt(1, course_id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int course_ID = rs.getInt("course_id");
				String course_Name = rs.getString("course_name");
				int total_Seats = rs.getInt("total_seat");
				
				int course_Fee = rs.getInt("course_fee");
				int remaining_Seats = rs.getInt("remaining_seats");
				
				course = new Course(course_ID,course_Name,total_Seats,course_Fee,remaining_Seats);
			}else{
				System.out.println("Course Not Found");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return course;
	}

}
