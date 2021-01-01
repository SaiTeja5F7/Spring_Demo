package com.sai.utility;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sai.Exceptions.ItemException;
import com.sai.Exceptions.RestaurantException;
import com.sai.Exceptions.UsersDetailsException;

@RestControllerAdvice
@PropertySource("classpath:messages.properties") 
public class ExceptionController {
	@Autowired 
	Environment environment;
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<ErrorInfo> noRestaurant(RestaurantException restaurantException){
		ErrorInfo err=new ErrorInfo();
		err.setErrorCode(HttpStatus.NOT_FOUND.value()); 
		err.setErrorMessage(environment.getProperty(restaurantException.getMessage()));
		err.setTimestamp(LocalDate.now());
		System.out.println(environment.getProperty(restaurantException.getMessage())); 
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.OK);
		
	}
	
	
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<ErrorInfo> noRestaurantFound(ItemException itemException){
		ErrorInfo err=new ErrorInfo();
		err.setErrorCode(HttpStatus.NOT_FOUND.value());
		err.setErrorMessage(environment.getProperty(itemException.getMessage()));
		err.setTimestamp(LocalDate.now());
		System.out.println(environment.getProperty(itemException.getMessage())); 
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UsersDetailsException.class)
	public ResponseEntity<ErrorInfo> userExceptions(UsersDetailsException userException){
		ErrorInfo err=new ErrorInfo();
		err.setErrorCode(HttpStatus.NOT_FOUND.value());
		err.setErrorMessage(environment.getProperty(userException.getMessage()));
		err.setTimestamp(LocalDate.now());
		System.out.println(environment.getProperty(userException.getMessage())); 
		return new ResponseEntity<ErrorInfo>(err,HttpStatus.OK);
		
	}
	
	
}
