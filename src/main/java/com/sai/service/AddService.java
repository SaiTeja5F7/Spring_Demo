package com.sai.service;

import com.sai.Exceptions.RestaurantException;
import com.sai.model.Restaurant;

public interface AddService {
	String addRestaurant(Restaurant restaurant) throws RestaurantException;
}
