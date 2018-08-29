package com.cg.equipment.bean;

import javax.persistence.Entity;

import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class UserBean {
	
	@Id
	private String userId;
	private String userName;
	private String password;
	/*@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Location location;*/
	private String departmentId;
	private boolean authorisation;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	/*public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}*/
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public boolean isAuthorisation() {
		return authorisation;
	}
	public void setAuthorisation(boolean authorisation) {
		this.authorisation = authorisation;
	}
	
	

}
