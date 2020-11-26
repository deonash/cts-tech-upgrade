package com.social.media.user.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.social.media.user.User;

@Component
public class SocialMediaDaoService {

	public static List<User> users = new ArrayList<User>();
	static
	{
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
		return users.get(id);
	}
}
