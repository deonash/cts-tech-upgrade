package com.cts.sv.resource.mgmt.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "smuser")
public class SVCUser {
	
	@Id
	@GeneratedValue
	Long id;
	@Column
	String username;
	@Column
	Date birthdate;
	
	
	
	public SVCUser() {
		super();
			}
	
	public SVCUser(String username, Date birthdate) {
		super();
		this.username = username;
		this.birthdate = birthdate;	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public Date getbirthdate() {
		return birthdate;
	}
	public void setbirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	
	
	

}
