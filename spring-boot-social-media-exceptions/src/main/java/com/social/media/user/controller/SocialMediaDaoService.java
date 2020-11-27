package com.social.media.user.controller;


import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.social.media.user.User;

@Component
public class SocialMediaDaoService {

	public static List<User> users = new ArrayList<User>();
	public static Integer count = 3;
	static
	{
		users.add(new User(0,"Inchara",new Date()));
		users.add(new User(1,"Avinash",new Date()));
		users.add(new User(2,"Macys",new Date()));
		users.add(new User(3,"Tech",new Date()));
	}
	
	
	public List<User> getAllUsers()
	{
		return users;
	}
	
	public User getUserById(Integer id)
	{
		if(id < users.size())
		return users.get(id);
		return null;
	}

	public User createUser(User user) {
		
		if(user.getId() == null)
		{
			user.setId(++count);
		}
		
		users.add(user);
		return user;
		
				}
}
