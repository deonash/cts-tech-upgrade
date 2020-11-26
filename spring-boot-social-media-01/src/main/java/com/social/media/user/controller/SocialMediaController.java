package com.social.media.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
