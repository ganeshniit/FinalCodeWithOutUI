package com.alibaba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity

public class Register {

	@Id
	@GeneratedValue//for generating the sequence i.e userId.1,userId.2,userId.3
	private int userId;
	
	@NotEmpty(message="username should not be empty")
	private String userName;
	@NotEmpty(message="email should not be empty")
	private String email;
	@NotEmpty(message="password should not be empty")
	private String password;
	
	private boolean enabled;


	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	
}
