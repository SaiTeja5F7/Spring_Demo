package com.sai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.Exceptions.UsersDetailsException;
import com.sai.entity.RestaurantEntity;
import com.sai.entity.UsersEntity;
import com.sai.model.Restaurant;
import com.sai.model.Users;
import com.sai.repository.UserRepository;

@Service(value="UserService")
public class UserSearchImple implements UserSearch {

	@Autowired
	UserRepository ur;
	
	@Override
	public Users getUserDetails(int userId) throws UsersDetailsException {
		
		Optional<UsersEntity> users=ur.findById(userId);
		UsersEntity user=users.orElseThrow( () -> new UsersDetailsException("User.NOT_FOUND"));
		Users result=new Users();
		result.setUserId(user.getUserId());
		result.setUserName(user.getUserName());
		result.setEmailId(user.getEmailId());
		result.setContactNumber(user.getContactNumber());
		List<RestaurantEntity> restaurants= user.getRestaurants();
		List<Restaurant> temp=new ArrayList<Restaurant>();
		
		if(restaurants.isEmpty()) {
			result.setRestaurants(new ArrayList<Restaurant>());
		}
		else {
			restaurants.forEach(restaurant -> {
				Restaurant rest=new Restaurant();
				rest.setAddressLine1(restaurant.getAddressLine1());
				rest.setApprovalStatus(restaurant.getApprovalStatus());
				rest.setArea(restaurant.getArea());
				rest.setAvgRating(restaurant.getAvgRating());
				rest.setCity(restaurant.getCity());
				rest.setPincode(restaurant.getPincode());
				rest.setResState(restaurant.getResState());
				rest.setRestaurantContact(restaurant.getRestaurantContact());
				rest.setRestaurantId(restaurant.getRestaurantId());
				rest.setRestaurantName(restaurant.getRestaurantName());
				rest.setRestaurantType(restaurant.getRestaurantType());
				rest.setPhotoUrls(restaurant.getPhotoUrls());
				temp.add(rest);
			});
		}
		result.setRestaurants(temp);
		
		
		
		
		return result;
		
		
	}

}
