package com.tech.kj.dto;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

public class UserDto {

    private String name;
    private String email;
    private String userName;
    private String password;
    private String roles;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", email=" + email + ", userName=" + userName + ", password=" + password
				+ ", roles=" + roles + "]";
	}
    
    
}

