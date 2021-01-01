package com.sai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.Exceptions.ItemException;
import com.sai.Exceptions.RestaurantException;
import com.sai.entity.RestaurantEntity;
import com.sai.model.Restaurant;
import com.sai.repository.RestaurantRepository; 

@Service(value="searchService")
@Transactional
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private RestaurantRepository rr;
	

	
	@Override
	public List<Restaurant> viewAllRestaurants() throws RestaurantException {  
		
		Iterable<RestaurantEntity> optional=rr.findAll();
		
		List<Restaurant> restaurants=new ArrayList<>();
		optional.forEach( restaurant -> {
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
			restaurants.add(rest);
		});
		if(restaurants.isEmpty()) {
			System.out.println("Hii1"); 
			throw new RestaurantException("SearchService.NO_RESTAURANTS_FOUND");  
		}
		return restaurants;
		
	}
	@Override
	
	public List<Restaurant> findByRestaurantName(String restaurant) throws ItemException{
		List<RestaurantEntity> res=rr.findByRestaurantName(restaurant);
		List<Restaurant> restaurants=new ArrayList<>();
		res.forEach( temp -> {
			Restaurant rest=new Restaurant();
			rest.setAddressLine1(temp.getAddressLine1());
			rest.setApprovalStatus(temp.getApprovalStatus());
			rest.setArea(temp.getArea());
			rest.setAvgRating(temp.getAvgRating());
			rest.setCity(temp.getCity());

			rest.setPincode(temp.getPincode());
			rest.setResState(temp.getResState());
			rest.setRestaurantContact(temp.getRestaurantContact());
			rest.setRestaurantId(temp.getRestaurantId());
			rest.setRestaurantName(temp.getRestaurantName());
			rest.setRestaurantType(temp.getRestaurantType());
			restaurants.add(rest);
		});
		
		if(res.isEmpty()) {
			throw new ItemException("SearchService.RESTAURANT_NOT_FOUND");
		}
		return restaurants; 
		
	}
	
	
}
