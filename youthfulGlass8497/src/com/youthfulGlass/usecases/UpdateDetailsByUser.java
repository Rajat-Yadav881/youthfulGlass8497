package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.StudentDao;
import com.youthfulGlass.dao.StudentDaoImpl;
import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Student;

public class UpdateDetailsByUser {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter the address: ");
		String address = sc.next();
		System.out.print("Enter the contact number: ");
		String contact_no = sc.next();
		System.out.print("Enter the Email: ");
		String mail = sc.next();
		System.out.print("Enter the identification: ");
		String identification = sc.next();
		System.out.print("Enter the password: ");
		String password = sc.next();
		
		
		Student student = new Student();
		
		student.setAddress(address);
		student.setContact_no(contact_no);
		student.setMail(mail);
		student.setIdentification(identification);
		student.setPassword(password);
		
		StudentDao dao = new StudentDaoImpl();
		try {
			String message = dao.UpdateDetails(student);
			
			System.out.println(message);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
