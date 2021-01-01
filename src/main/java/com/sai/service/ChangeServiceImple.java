package com.sai.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sai.Exceptions.RestaurantException;
import com.sai.entity.RestaurantEntity;
import com.sai.repository.RestaurantRepository;

@Service(value="changeService")
@Transactional
public class ChangeServiceImple implements ChangeService {

	@Autowired
	RestaurantRepository rr;
	
	@Autowired
	Environment environment;
	
	@Override
	public String changeRestaurants(int restaurantId, double avgRating) throws RestaurantException  {
		 
		Optional<RestaurantEntity> restaurant=rr.findById(restaurantId);
		RestaurantEntity res= restaurant.orElseThrow(()-> new RestaurantException("Change.NOT_FOUND")); 
		res.setAvgRating(avgRating);  
		rr.save(res);
		return environment.getProperty("Change.Success");
		
	}

}
