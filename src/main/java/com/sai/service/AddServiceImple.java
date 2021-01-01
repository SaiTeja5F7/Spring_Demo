package com.sai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sai.Exceptions.RestaurantException;
import com.sai.entity.RestaurantEntity;
import com.sai.model.Restaurant;
import com.sai.repository.RestaurantRepository;

@Service(value="addService")
public class AddServiceImple implements AddService {

	@Autowired
	Environment environment;
	
	@Autowired
	RestaurantRepository rr;
	
	@Override
	public String addRestaurant(Restaurant restaurant) throws RestaurantException {
		
		RestaurantEntity re=new RestaurantEntity(); 
		re.setAddressLine1(restaurant.getAddressLine1());
		re.setArea(restaurant.getArea());
		re.setAvgRating(restaurant.getAvgRating());
		re.setPincode(restaurant.getPincode());
		re.setResState(restaurant.getResState());
		re.setRestaurantContact(restaurant.getRestaurantContact());
		re.setRestaurantName(restaurant.getRestaurantName());
		re.setRestaurantType(restaurant.getRestaurantType());
		re.setPhotoUrls(restaurant.getPhotoUrls());
		re.setApprovalStatus(restaurant.getApprovalStatus()); 
		re.setCity(restaurant.getCity());
		
		List<RestaurantEntity> optional= rr.findByRestaurant(restaurant.getRestaurantName(), restaurant.getRestaurantContact());
		if(optional.isEmpty()) {
			RestaurantEntity saved=rr.save(re);
			if(saved.getRestaurantId()!=null)
					return environment.getProperty("RegisterService.Success")+" With Restaurant Id"+saved.getRestaurantId();
		}
		else {
			throw new RestaurantException("RegisterService.FOUND");  
		} 
		return environment.getProperty("RegisterService.SOME_ERROR");
		
	}
	

}
