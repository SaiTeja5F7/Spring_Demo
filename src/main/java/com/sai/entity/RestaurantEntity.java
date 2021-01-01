package com.sai.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.sai.utility.StringListConverter;

@Entity
@Table(name = "RESTAURANT")

public class RestaurantEntity {  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer restaurantId;
	
	@Column(name = "user_id")
	private String userId;
	
	private String restaurantName;

	private String restaurantContact;

	private String restaurantType;

	private String addressLine1;

	private String area;

	private String city;

	private String resState;

	private Integer pincode;

	private String approvalStatus;

	private Double avgRating;
	
	@Convert(converter=StringListConverter.class)
	private List<String> photoUrls; 

	
	public RestaurantEntity() {			}
	 
	public RestaurantEntity(Integer restaurantId, String userId, String restaurantName, String restaurantContact,
			String restaurantType, String addressLine1, String area, String city, String resState, Integer pincode,
			String approvalStatus, Double avgRating, List<String> photoUrls) {
		
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.restaurantName = restaurantName;
		this.restaurantContact = restaurantContact;
		this.restaurantType = restaurantType;
		this.addressLine1 = addressLine1;
		this.area = area;
		this.city = city;
		this.resState = resState;
		this.pincode = pincode;
		this.approvalStatus = approvalStatus;
		this.avgRating = avgRating;
		this.photoUrls = photoUrls;
	}

	/*
	  public List<DishEntity> getDishes() {
		return dishes;
	}

	public void setDishes(List<DishEntity> dishes) {
		this.dishes = dishes;
	}

	public RestaurantTransactionEntity getTransaction() {
		return transaction;
	}

	public void setTransaction(RestaurantTransactionEntity transaction) {
		this.transaction = transaction;
	}


	@OneToMany(cascade= CascadeType.ALL) 
	  @JoinColumn(name = "restaurant_id")
	  private List<DishEntity> dishes;
	  
	 @OneToOne(cascade = CascadeType.ALL)
	 
	 @JoinColumn(name = "restaurant_id", unique = true) private
	  RestaurantTransactionEntity transaction;
	*/ 
	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantContact() {
		return restaurantContact;
	}

	public void setRestaurantContact(String restaurantContact) {
		this.restaurantContact = restaurantContact;
	}

	public String getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getResState() {
		return resState;
	}

	public void setResState(String resState) {
		this.resState = resState;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) { 
		this.pincode = pincode;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public List<String> getPhotoUrls() { 
		return photoUrls;
	}

	public void setPhotoUrls(List<String> list) {
		this.photoUrls = list;
	}

	

}
