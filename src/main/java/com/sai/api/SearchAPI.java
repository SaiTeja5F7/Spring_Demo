package com.sai.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.Exceptions.ItemException;
import com.sai.Exceptions.RestaurantException;
import com.sai.model.Restaurant;
import com.sai.service.AddService;
import com.sai.service.ChangeService;
import com.sai.service.DeleteService;
import com.sai.service.SearchService; 

@CrossOrigin
@RestController
@RequestMapping("searchAPI")
public class SearchAPI {

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private AddService addService;
	
	@Autowired
	private ChangeService changeService;
	
	@Autowired
	private DeleteService deleteService;
	
	@Autowired
	private Environment environment;
	
	//View all the restaurants registered to the application
	@GetMapping(value = "/viewAllRestaurants") 
	public ResponseEntity<List<Restaurant>> viewAllRestaurants() throws RestaurantException{
			List<Restaurant> restaurants = searchService.viewAllRestaurants();
			return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK); 
			
			/*catch(Exception e){
				System.out.println(e.getMessage()); 
				System.out.println(environment.getProperty(e.getMessage()));  
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()));
			}*/
	}
	
	@GetMapping(path="/getRestaurant/{restaurantName}")
	public ResponseEntity<List<Restaurant>> getRestaurant(@PathVariable("restaurantName") String restaurantName) throws ItemException{
		List<Restaurant> restaurants = searchService.findByRestaurantName(restaurantName); 
		return new ResponseEntity<List<Restaurant>>(restaurants,HttpStatus.OK);  
	}
	
	@PostMapping(path="/registerRestaurant")
	public ResponseEntity<String> registerUser(@RequestBody Restaurant restaurant) throws RestaurantException{
		
		String res=addService.addRestaurant(restaurant);
		
		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="/changeRestaurant/{restaurantId}/{avgRating}")
	public ResponseEntity<String> changeRestaurant(@PathVariable("restaurantId")int restaurantId, @PathVariable("avgRating") double avgRating) throws RestaurantException{
		String updated = changeService.changeRestaurants(restaurantId,avgRating); 
		return new ResponseEntity<String>(updated, HttpStatus.OK);   
	}
	
	@DeleteMapping(path="/deleteRestaurant/{restaurantId}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable("restaurantId")int restaurantId) throws RestaurantException{
		String updated = deleteService.deleteRestaurant(restaurantId); 
		return new ResponseEntity<String>(updated, HttpStatus.OK);   
	}
	
	
		
}

