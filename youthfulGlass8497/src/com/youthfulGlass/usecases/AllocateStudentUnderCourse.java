package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.CourseDao;
import com.youthfulGlass.dao.CourseDaoImpl;
import com.youthfulGlass.exception.BatchException;
import com.youthfulGlass.exception.StudentException;

public class AllocateStudentUnderCourse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the student ID: ");
		int student_id = sc.nextInt();
		
		System.out.print("Enter the course name : ");
		String course_name  = sc.next();
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			String message = dao.allocateStudent(student_id, course_name);
			System.out.println(message);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
	}
}
