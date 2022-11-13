package com.youthfulGlass.utility;

import java.sql.Connection;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.youthfulGlass.extra.RandomPasswordGenerator;
import com.youthfulGlass.extra.ScannerMatchPassword;
//import com.youthfulGlass.extra.ScannerMatchPassword;
import com.youthfulGlass.usecases.AdminLogin;
//import com.youthfulGlass.usecases.AllocateStudentUnderCourse;
//import com.youthfulGlass.usecases.BatchUnderCourse;
//import com.youthfulGlass.usecases.CourseDetails;
//import com.youthfulGlass.usecases.DeleteTheCourseData;
//import com.youthfulGlass.usecases.UpdateSeats;
//import com.youthfulGlass.usecases.UpdateTheFee;
//import com.youthfulGlass.usecases.GetAllStudents;
//import com.youthfulGlass.usecases.SetTheCourse;
import com.youthfulGlass.usecases.GetAllCourses;
import com.youthfulGlass.usecases.LoginStudent;
import com.youthfulGlass.usecases.SetStudentDetails;
import com.youthfulGlass.usecases.StudentSetterLogin;
import com.youthfulGlass.usecases.UpdateDetailsByUser;


public class Main {
	
	public static synchronized  void main(String[] args) {
		
		String q1 = RandomPasswordGenerator.generateRandomPassword(5);
		System.err.println("Varification password: "+q1);
		System.out.println("Enter code to varify: ");
		String q2 = ScannerMatchPassword.Scan();
		
		if(q1.equals(q2)) {
			@SuppressWarnings("resource")
			Scanner sc1 = new Scanner(System.in);

			 new Thread(new Runnable() {
		            @Override
		            public void run() {
		                master();               
		            }
		     }).start();
		        System.out.println("Welcome to the Automated Student Ragisteration System");
		        System.out.println("Loading...");
		        System.out.println("Please wait once");
		        try {
					TimeUnit.MILLISECONDS.sleep(2000);
				} catch (InterruptedException e) {

					e.getMessage();
				}
			
			
			
			@SuppressWarnings("unused")
			Connection conn1 = DBAUtility.provideConnection();
			boolean mainBool = true;
			while(mainBool) {
				System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
				System.out.println();
				System.out.println("Select Adim/Student");
				System.out.println("-----------------------");
				System.out.println("1.Admin");
				System.out.println("2.Student");
				System.out.println("3.Exit");
				System.out.println("-----------------------");
				System.out.println();
				System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
				int choice = sc1.nextInt();
					switch (choice) {
					case 1: {
						AdminLogin.main(null);				
						break;
					}
					case 2: {
						boolean n = true;
						while(n) {
							System.out.println("========================");
							System.out.println("1.Register new Student");
							System.out.println("2.Login registered Student");
							System.out.println("3.Back");
							System.out.println("========================");
							int choice301 = sc1.nextInt();
							switch (choice301) {
							case 1: {
								SetStudentDetails.main(null);
								break;
							}
							case 2: {
								StudentSetterLogin.main(null);
								break;
							}
							case 3:{
								n = false;
								break;
							}
							default:
								System.out.println("Unexpected value: " + choice301);
								break;
							}
						}
						
						break;
					}
					case 3: {
						mainBool = false;
						break;		
					}
					default:
						System.out.println("Unexpected value: " + choice);
						break;
					}

			}
		}else {
			System.out.println("please Enter the correct 5 Digit varification password...");
		}
		
		
				
	}
	public static synchronized void master() {
		System.out.println("Thankyou for visiting...");
	}
}
