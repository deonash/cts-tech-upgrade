package com.social.media.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.social.media.user.User;


@RestController
public class SocialMediaController {
	
	@Autowired
	private SocialMediaDaoService service;
	
	@GetMapping(path = "/users")
	List<User> dashboardUsers()
	{
		System.out.println("in users menu");
		return service.getAllUsers();
	}
	
	@GetMapping(path = "/users/{userId}")
	User findUserById(@PathVariable Integer userId)
	{
		return service.getUserById(userId);
	}

	@PostMapping(path = "/users")
	ResponseEntity<Object> createUser(@RequestBody User user)
	{
		User userSaved = service.createUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri();
		return ResponseEntity.created(location).build()	;
			
	}
}
