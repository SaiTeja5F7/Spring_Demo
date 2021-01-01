package com.sai.service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sai.Exceptions.UsersDetailsException;
import com.sai.entity.RestaurantEntity;
import com.sai.entity.UsersEntity;
import com.sai.model.Users;
import com.sai.repository.UserRepository;
import com.sai.utility.HashingUtility;

@Service(value="UserCreate")
public class UsersCreateImple implements UserCreate {

	@Autowired
	UserRepository ur;
	
	@Autowired
	Environment environment;
	
	@Override
	public String createUser(Users user) throws UsersDetailsException, NoSuchAlgorithmException {
		
		UsersEntity resultEntity=ur.findByName(user.getContactNumber(),user.getUserName());
		if(resultEntity != null){ 
			return environment.getProperty("User.Found");
		}
		UsersEntity ue=new UsersEntity();
		ue.setContactNumber(user.getContactNumber());
		ue.setEmailId(user.getEmailId());
		ue.setPassword(HashingUtility.getHashValue(user.getPassword()));
		ue.setUserName(user.getUserName());
		
		UsersEntity saved=ur.save(ue);
		if(saved.getUserId()!=null)
				return environment.getProperty("User.Success")+" With Restaurant Id"+saved.getUserId();
		return environment.getProperty("User.Error"); 
	}

}
