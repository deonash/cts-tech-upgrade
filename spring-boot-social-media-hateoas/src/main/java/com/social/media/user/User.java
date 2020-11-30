package com.social.media.user;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

public class User{
	Integer id;
	@Size(min=2, message="Name should be at least 2 chars!!")
	String userName;
	@Future
	Date birthDate;
	
	
	
	public User() {
			}

	public User(Integer id, String userName, Date birthDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.birthDate = birthDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	
	
	

}
