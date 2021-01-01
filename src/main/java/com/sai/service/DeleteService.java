package com.sai.service;

import com.sai.Exceptions.RestaurantException;

public interface DeleteService {
	public String deleteRestaurant(int restaurantId) throws RestaurantException; 
}
