package com.sai.repository;

import org.springframework.data.repository.CrudRepository;

import com.sai.entity.UsersEntity;

public interface UserRepository extends CrudRepository <UsersEntity,Integer> { 

	UsersEntity findByName(String contact,String name); 
}
