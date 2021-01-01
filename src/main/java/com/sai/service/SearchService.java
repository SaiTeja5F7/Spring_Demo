package com.sai.service;

import java.util.List;

import com.sai.Exceptions.ItemException;
import com.sai.Exceptions.RestaurantException;
import com.sai.entity.RestaurantEntity;
import com.sai.model.Restaurant;

public interface SearchService {
	public List<Restaurant> viewAllRestaurants() throws RestaurantException; 
	
	public List<Restaurant> findByRestaurantName(String restaurantName) throws ItemException;
}
