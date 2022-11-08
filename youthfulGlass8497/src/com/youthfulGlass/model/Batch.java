package com.youthfulGlass.model;

public class Batch {
	
	
	private int student_id;
	private String student_name;
	private int course_id;
	private String mail;
	private String course_name;
	private String date_of_join;
	
	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Batch(int student_id, String student_name, int course_id, String mail, String course_name,
			String date_of_join) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.course_id = course_id;
		this.mail = mail;
		this.course_name = course_name;
		this.date_of_join = date_of_join;
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


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getCourse_name() {
		return course_name;
	}


	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


	public String getDate_of_join() {
		return date_of_join;
	}


	public void setDate_of_join(String date_of_join) {
		this.date_of_join = date_of_join;
	}


	@Override
	public String toString() {
		return "Batch [student_id=" + student_id + ", student_name=" + student_name + ", course_id=" + course_id
				+ ", mail=" + mail + ", course_name=" + course_name + ", date_of_join=" + date_of_join + "]";
	}
	
	
	
}
