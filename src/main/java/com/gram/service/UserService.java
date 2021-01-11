package com.gram.service;

import java.util.List;

import com.gram.model.User;

public interface UserService {
	
	List<User>findAll();
	User findOne(Long id);
	void save(User user);
	User remove(Long id);
	List<User>FindByName(String userName);

}
