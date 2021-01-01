package com.sai.service;

import com.sai.Exceptions.RestaurantException;
import com.sai.model.Restaurant;

public interface ChangeService {
	public String changeRestaurants(int restaurantId,double avgRating) throws RestaurantException;
	
}
