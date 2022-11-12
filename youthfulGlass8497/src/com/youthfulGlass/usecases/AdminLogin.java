package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.model.Admin;
public class AdminLogin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean hc = true;
		while(hc) {
			System.out.println("========================");		
			System.out.println("1.Login registered Admin");
			System.out.println("2.Exit");
			System.out.println("========================");
			int choice101 = sc.nextInt();
			switch (choice101) {
			case 1: {
				
				Admin admin = new Admin();
			
				
				
				System.out.print("Enter the username: ");
				String username101  = sc.next();
				
				System.out.print("Enter the Password: ");
				String password101 = sc.next();
				
				if(username101.equals(admin.getUsername()) && password101.equals(admin.getPassword())) {
					boolean dv = true;
					while(dv) {
						System.out.println("Login successfull...");
						System.out.println();
						System.out.println("========================");
						System.out.println("1.Add the course");
						System.out.println("2.Update the fees");
						System.out.println("3.Delete the course");
						System.out.println("4.Get the details of the course");
						System.out.println("5.Create Batch Under the course");
						System.out.println("6.Allocate Student");
						System.out.println("7.Update the Seats in the course");
						System.out.println("8.Get all the details of student under the course");
						System.out.println("9.Exit");
						System.out.println("========================");
						
						int choice111 = sc.nextInt();
						
						switch (choice111) {
						case 1: {		
							System.out.println("1.Add the course");
							SetTheCourse.main(null);
							break;
						}
						case 2: {	
							System.out.println("2.Update the fees");
							UpdateTheFee.main(null);
							break;
						}
						case 3: {
							System.out.println("3.Delete the course");
							DeleteTheCourseData.main(null);
							break;
						}
						case 4: {	
							System.out.println("4.Get the details of the course");
							CourseDetails.main(null);
							break;
						}
						case 5: {	
							System.out.println("5.Create Batch Under the course");
							BatchUnderCourse.main(null);
							break;
						}
						case 6: {	
							System.out.println("6.Allocate Student");
							AllocateStudentUnderCourse.main(null);
							break;
						}
						case 7: {
							System.out.println("7.Update the Seats in the course");
							UpdateSeats.main(null);
							break;
						}
						case 8: {	
							System.out.println("8.Get all the details of student under the course");
							GetAllStudents.main(null);
							break;
						}
						case 9: {
							dv = false;
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + choice111);
							
						}
						
					}				
				}else {
					throw new IllegalArgumentException("Unexpected value");
				}
			}
			case 2: {
				hc = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice101);
			
			}
		}
		
	}
}
