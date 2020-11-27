package com.social.media.user;

import java.util.Date;

public class User{
	Integer id;
	String userName;
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
