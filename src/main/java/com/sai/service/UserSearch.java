package com.sai.service;

import java.util.List;
import java.util.Optional;

import com.sai.Exceptions.UsersDetailsException;
import com.sai.entity.UsersEntity;
import com.sai.model.Users;



public interface UserSearch {
	Users getUserDetails(int UserId) throws UsersDetailsException;  

}
