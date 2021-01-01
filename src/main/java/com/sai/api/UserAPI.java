package com.sai.api;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.Exceptions.UsersDetailsException;
import com.sai.model.Users;
import com.sai.service.UserCreate;
import com.sai.service.UserSearch;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserAPI {

		@Autowired 
		private UserSearch userSearch; 
		
		@Autowired
		private UserCreate userCreate;
		
		@GetMapping(path="/userDetails/{userId}")
		public ResponseEntity<Users> getUserDetails(@PathVariable("userId") int userId) throws UsersDetailsException {
			Users user=userSearch.getUserDetails(userId);
			return new ResponseEntity<Users>(user,HttpStatus.OK); 
		}
		
		@PostMapping(path="/registerUser")
		public ResponseEntity<String> registerUser(@RequestBody Users user) throws UsersDetailsException, NoSuchAlgorithmException{
			
			String message=userCreate.createUser(user); 
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
}
