package com.sai.service;

import java.security.NoSuchAlgorithmException;

import com.sai.Exceptions.UsersDetailsException;
import com.sai.model.Users;

public interface UserCreate {
	public String createUser(Users user) throws UsersDetailsException, NoSuchAlgorithmException;
}
