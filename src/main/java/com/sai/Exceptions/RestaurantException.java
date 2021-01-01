package com.sai.Exceptions;

public class RestaurantException extends Exception{
	
	private static final long serialVersionUID = 1L; 

	public RestaurantException(String message) {
		super(message); 
		System.out.println("Hiii2");
		
	}
}
