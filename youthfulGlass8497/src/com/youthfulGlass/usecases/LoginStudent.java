package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.StudentDao;
import com.youthfulGlass.dao.StudentDaoImpl;
import com.youthfulGlass.exception.StudentException;

public class LoginStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter the Email: ");
		String mail = sc.next();
		
		System.out.print("Enter the password: ");
		String password = sc.next();
		
		StudentDao dao = new StudentDaoImpl();
		try {
			String message = dao.loginStudent(mail, password);
			System.out.println(message);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
