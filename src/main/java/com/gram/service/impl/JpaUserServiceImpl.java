package com.gram.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gram.model.User;
import com.gram.repository.UserRepository;
import com.gram.service.UserService;

@Service
@Transactional
public class JpaUserServiceImpl 
implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User remove(Long id) {
		User user = userRepository.getOne(id);
		if(user != null) {
			userRepository.delete(user);
		}
		return user;
	}

	@Override
	public List<User> FindByName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
