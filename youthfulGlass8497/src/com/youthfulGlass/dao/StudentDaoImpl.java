package com.youthfulGlass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Course;
import com.youthfulGlass.model.Student;
import com.youthfulGlass.utility.DBAUtility;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String setDetails(Student student)
			throws StudentException {
		String message = "not Inserted...!";
		
		try(Connection conn = DBAUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into student(student_name,date_of_birth,parent_name,address,contact_no,mail,gender,identification,date_of_join,password) values(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, student.getStudent_name());
			ps.setString(2, student.getDate_of_birth());
			ps.setString(3, student.getParent_name());
			ps.setString(4, student.getAddress());
			ps.setString(5, student.getContact_no());
			ps.setString(6, student.getMail());
			ps.setString(7, student.getGender());
			ps.setString(8, student.getIdentification());
			ps.setString(9, student.getDate_of_join());
			ps.setString(10, student.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Student is Added successfully";
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new StudentException("Oops,student registration unsuccessful...!");
		}
		
		return message;
	}

	@Override
	public String loginStudent(String mail, String password) throws StudentException {
		String message = "Not Logged-In...";
		
		try(Connection conn = DBAUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from student where mail = ? and password = ?");
			
			
			ps.setString(2, password);
			ps.setString(1, mail);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int a = rs.getInt("student_id");
				String b = rs.getString("student_name");
				String c = rs.getString("date_of_birth");
				String x = rs.getString("parent_name");
				String d = rs.getString("address");
				String e = rs.getString("contact_no");
				String f = rs.getString("mail");
				String g = rs.getString("gender");
				String h = rs.getString("identification");
				String i = rs.getString("date_of_join");
				String j = rs.getString("password");
				
				Student student = new Student(a,b,c,x,d,e,f,g,h,i,j);
				
				message = "login successful...";
				
			}else {
				throw new StudentException("No Data found!!");
			}
		 
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return message;
	}

	@Override
	public String UpdateDetails(Student student) throws StudentException {
		
		String message = "Data is not updated...";
		
		try(Connection conn = DBAUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update student set address = ?,contact_no = ?,mail = ?,identification = ?,password = ?");
			
			ps.setString(1, student.getAddress());
			ps.setString(2, student.getContact_no());
			ps.setString(3, student.getMail());
			ps.setString(4, student.getIdentification());
			ps.setString(5, student.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = student.getStudent_name() + "date is been updated...!";
			}else {
				throw new StudentException("data Updated failed...!");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return message;
		
	}

	@Override
	public List<Course> getAllCourses() throws StudentException,CourseException {
		List<Course> arr = new ArrayList<>();
		
		try (Connection conn = DBAUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from course");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int a = rs.getInt("course_id");
				String b = rs.getString("course_name");
				int x = rs.getInt("total_seat");
				int y = rs.getInt("course_fee");
				int c = rs.getInt("remaining_seats");
				
				arr.add(new Course(a,b,x,y,c));
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.getMessage();
			throw new StudentException("no data found Error...");
		}
		
		return arr;
	}

}
