package com.youthfulGlass.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.youthfulGlass.exception.BatchException;
import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Batch;
import com.youthfulGlass.model.BatchStudent;
import com.youthfulGlass.model.Course;
import com.youthfulGlass.model.Student;
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
			conn.close();
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
			conn.close();
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
			conn.close();
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
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return course;
	}

	@Override
	public String createBatchUnderCourse(Student student, int course_id, String course_name)
			throws CourseException {
		String message = null;
		
		try(Connection conn = DBAUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from course where course_id = ? and course_name = ?");
			
			ps.setInt(1, course_id);
			ps.setString(2, course_name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				
				PreparedStatement ps1 = conn.prepareStatement("insert into batch values(?,?,?,?,?,?)");
				
				ps1.setInt(1, student.getStudent_id());
				ps1.setString(2, student.getStudent_name());
				ps1.setInt(3, course_id);
				ps1.setString(4, student.getMail());
				ps1.setString(5, course_name);
				ps1.setString(6, student.getDate_of_join());
				
				int x = ps1.executeUpdate();
				
				if(x>0) {
					message = "batch is updated under the course...!";
				}
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CourseException("no batch is registered....!");
		}
		
		return message;
	}
	
	
	
	@Override
	public String allocateStudent(int student_id, String course_name) throws StudentException, BatchException {
		String message = "no Student is allocated...";
		
		try(Connection conn = DBAUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from student where student_id = ?");
			
			ps.setInt(1, student_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps1 = conn.prepareStatement("insert into batchStudent values(?,?)");
				
				
				ps1.setInt(1, student_id);
				ps1.setString(2, course_name);
				
				int x = ps1.executeUpdate();
				
				if(x>0) {
					
					PreparedStatement ps2 = conn.prepareStatement("update batch set remaining_seats = remaining_seats - 1 where student_id = ? ");
					
					ps2.setInt(1, student_id);
					
					int y = ps2.executeUpdate();
					
					
					
				}else {
					throw new BatchException("student is not allocated in the batch...");
				}
				conn.close();
			}
			
		}catch (SQLException e) {
			
			e.getMessage();
			
		}
		
		
		return message;
	}
	
	

	@Override
	public String updateSeats(int course_id, int remaining_seats) throws CourseException {
		String message = "no seats are updated...";

		
		try(Connection conn = DBAUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update course set remaining_seats = ? where course_id = ?");
			
			ps.setInt(1, remaining_seats);
			ps.setInt(2, course_id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Seats are Updated successfully";
			}
			conn.close();
			
		}catch (SQLException e) {

			e.getMessage();
			
			throw new CourseException("updation Error...");
			
		}
		
		
		
		
		return message;
	}

	@Override
	public List<BatchStudent> getAllStudentUnderCourse(String course_name) {
		List<BatchStudent> arr = new ArrayList<>();
		
		try(Connection conn = DBAUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select b.course_name , b.student_id , b.student_name , b.mail , s.password from batch b inner join student s inner join course c on b.student_id = s.student_id and c.course_name = b.course_name having course_name = ?");
			
			ps.setString(1, course_name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String cn = rs.getString("course_name");
				int sid = rs.getInt("student_id");
				String sn = rs.getString("student_name");
				String em = rs.getString("mail");
				String psw = rs.getString("password");
				
				
				arr.add(new BatchStudent(cn,sid,sn,em,psw));
			}
			conn.close();
		}catch (SQLException e) {
			
			e.getMessage();

		}
		
		
		return arr;
	}

	
	
	

}
