package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.CourseDao;
import com.youthfulGlass.dao.CourseDaoImpl;
import com.youthfulGlass.exception.CourseException;
//import com.youthfulGlass.model.Batch;
import com.youthfulGlass.model.Student;

public class BatchUnderCourse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the student ID: ");
		int student_id = sc.nextInt();
		System.out.print("Enter the student name: ");
		String student_name = sc.next();
		System.out.print("Enter the course ID: ");
		int course_id = sc.nextInt();
		System.out.print("Enter the Email: ");
		sc.nextLine();
		String Email = sc.nextLine();
		System.out.print("Enter the course name : ");
		String course_name  = sc.next();
		
		System.out.print("Enter the Date of joining: ");
		String date_of_joining = sc.next();
		
		
		Student student = new Student();
		
		student.setStudent_id(student_id);
		student.setStudent_name(student_name);
		
		student.setMail(Email);
		
		student.setDate_of_join(date_of_joining);
		
		
		CourseDao courseDao = new CourseDaoImpl();
		try {
			String s = courseDao.createBatchUnderCourse(student, course_id, course_name);
			System.out.println(s);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
}
