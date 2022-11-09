package com.youthfulGlass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Student;
import com.youthfulGlass.utility.DBAUtility;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String registerStudent(Student student)
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

}
