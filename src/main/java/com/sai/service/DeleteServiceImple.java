package com.sai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sai.Exceptions.RestaurantException;
import com.sai.entity.RestaurantEntity;
import com.sai.repository.RestaurantRepository;

@Service(value="DeleteService")
public class DeleteServiceImple implements DeleteService {

	@Autowired
	RestaurantRepository rr; 
	
	@Autowired
	Environment environment;
	
	@Override
	public String deleteRestaurant(int restaurantId) throws RestaurantException {
		Optional<RestaurantEntity> restaurant=rr.findById(restaurantId);
		RestaurantEntity entity=restaurant.orElseThrow(()->new RestaurantException("Delete.NOT_FOUND"));
		rr.delete(entity);
		return environment.getProperty("Delete.Success");
	}
	
}
