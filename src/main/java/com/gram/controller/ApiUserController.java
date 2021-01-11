package com.gram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gram.model.User;
import com.gram.service.UserService;

@RestController
@RequestMapping("/api/users")
public class ApiUserController {

	@Autowired
	private UserService userService;
	
//	GET ALL
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> get (){
		List<User> useri;
		useri = userService.findAll();
		if(useri == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(useri, HttpStatus.OK);
	}
//	SAVE EDIT USER
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<User> edit(@PathVariable Long id, @RequestBody User edited){
		
		userService.save(edited);
		return new ResponseEntity<>(edited, HttpStatus.OK);
		
	}
	
//	SAVE NEW USER
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<User> add (@RequestBody User newUser){
		
		userService.save(newUser);
		
		return new ResponseEntity(newUser, HttpStatus.OK);
	}
	
//	DELETE USER
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<User>delete(@PathVariable Long id){
		
		User user = userService.remove(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	
	
	
}
