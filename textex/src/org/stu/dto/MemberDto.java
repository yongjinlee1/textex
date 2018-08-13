package org.stu.dto;

import java.sql.Date;

public class MemberDto {

	
	private String id;
	private String name;
	private Date dob;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", name=" + name + ", dob=" + dob + ", email=" + email + "]";
	}
	
	
	
	
	
}
