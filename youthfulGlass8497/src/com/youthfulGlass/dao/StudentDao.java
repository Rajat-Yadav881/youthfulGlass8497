package com.youthfulGlass.dao;

import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Student;

public interface StudentDao {
	
	public String setDetails(Student student)throws StudentException;
	
	public String loginStudent(String mail,String password)throws StudentException;
	
	public String UpdateDetails()throws StudentException;
	
	
}
