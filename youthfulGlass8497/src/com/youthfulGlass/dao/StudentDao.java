package com.youthfulGlass.dao;

import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Student;

public interface StudentDao {
	public String registerStudent(Student student)throws StudentException;
}
