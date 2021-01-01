package com.sai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sai.entity.RestaurantEntity;
import com.sai.model.Restaurant; 


public interface RestaurantRepository extends CrudRepository <RestaurantEntity,Integer> {  
	@Query(value="select * from restaurant r where r.restaurant_name=?1",nativeQuery = true)
	List<RestaurantEntity> findByRestaurantName(String restaurantName); 
	
	@Query(value="select * from restaurant r where r.restaurant_contact=?2 and r.restaurant_name=?1 ",nativeQuery = true)
	List<RestaurantEntity> findByRestaurant(String restaurantName,String restaurantContact); 
	
	
} 



