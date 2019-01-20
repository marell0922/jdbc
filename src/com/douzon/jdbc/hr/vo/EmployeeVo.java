package com.douzon.jdbc.hr.vo;

public class EmployeeVo {
	
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String hire_date;
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	
	@Override
	public String toString() {
		return "성 : " + first_name + ", 이름 : " + last_name + ", email : " + email
				+ ", 전화번호 : " + phone_number + ", 입사일 : " + hire_date;
	}
	
}