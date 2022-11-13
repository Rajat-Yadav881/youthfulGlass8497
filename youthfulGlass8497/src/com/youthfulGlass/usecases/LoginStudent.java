package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.StudentDao;
import com.youthfulGlass.dao.StudentDaoImpl;
import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Student;

public class LoginStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter the Email: ");
		String mail = sc.next();
		
		System.out.print("Enter the password: ");
		String password = sc.next();
		
		StudentDao dao = new StudentDaoImpl();
		Student student = new Student();
		if(student.getPassword().equals(password) && student.getMail().equals(mail)) {
			try {
				String message = dao.loginStudent(mail, password);
				System.out.println(message);
			} catch (StudentException e) {
				e.getMessage();
			}
		}else {
			LoginStudent.main(null);
		}
		
		
		
	}
}
