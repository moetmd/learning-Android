package org.niit.entity;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String password;
	
	public User	(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
