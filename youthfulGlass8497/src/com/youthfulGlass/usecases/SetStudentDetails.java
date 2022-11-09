package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.StudentDao;
import com.youthfulGlass.dao.StudentDaoImpl;
import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Student;

public class SetStudentDetails {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter the student name: ");
		String student_name = sc.next();
		System.out.print("Enter the date of birth: ");
		String date_of_birth = sc.next();
		System.out.print("Enter the parent name: ");
		String parent_name = sc.next();
		System.out.print("Enter the address: ");
		String address = sc.next();
		System.out.print("Enter the contact number : ");
		String contact_no = sc.next();
		System.out.print("Enter the mail: ");
		String mail = sc.next();
		System.out.print("Enter the gender : ");
		String gender = sc.next();
		System.out.print("Enter the identification : ");
		String identification = sc.next();
		System.out.print("Enter the date of join : ");
		String date_of_join = sc.next();
		System.out.print("Enter the password : ");
		String password = sc.next();
		
		
		Student student = new Student();
		
		student.setStudent_name(student_name);
		student.setDate_of_birth(date_of_birth);
		student.setParent_name(parent_name);
		student.setAddress(address);
		student.setContact_no(contact_no);
		student.setMail(mail);
		student.setGender(gender);
		student.setIdentification(identification);
		student.setDate_of_join(date_of_join);
		student.setPassword(password);
		
		
		StudentDao dao = new StudentDaoImpl();
		
		try {
			String message = dao.setDetails(student);
			System.out.println(message);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
}
