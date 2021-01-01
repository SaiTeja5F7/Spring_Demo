package com.sai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
@NamedQuery(name = "UsersEntity.findByName",query = "SELECT u FROM UsersEntity u where u.contactNumber=?1 and u.userName=?2")
public class UsersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer userId;
	private String userName;
	private String emailId;
	private String contactNumber;
	private String password;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<RestaurantEntity> restaurants;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<RestaurantEntity> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<RestaurantEntity> restaurants) {
		this.restaurants = restaurants;
	}
	
	
	
	
}
