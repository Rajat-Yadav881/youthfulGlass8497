package com.youthfulGlass.model;

public class BatchStudent {
	
	private String course_name;
	private int student_id;
	private String student_name;
	private String email;
	private String password;
	
	
	public BatchStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BatchStudent(String course_name, int student_id, String student_name, String email, String password) {
		super();
		this.course_name = course_name;
		this.student_id = student_id;
		this.student_name = student_name;
		this.email = email;
		this.password = password;
	}
	
	
	public String getCourse_name() {
		return course_name;
	}
	
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
		return "BatchStudent [course_name=" + course_name + ", student_id=" + student_id + ", student_name="
				+ student_name + ", email=" + email + ", password=" + password + "]";
	}
		
	
	
	

}
