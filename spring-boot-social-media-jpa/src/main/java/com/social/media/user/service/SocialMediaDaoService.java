package com.social.media.user.service;


import java.net.URI;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.social.media.user.dao.UserRepository;
import com.social.media.user.domain.SMUser;


@Component
public class SocialMediaDaoService {

	@Autowired
	UserRepository userRep;	
	
	public List<SMUser> getAllUsers()
	{
		return (List<SMUser>) userRep.findAll();
	}
	
	public Optional<SMUser> getUserById(Long id)
	{
		return userRep.findById(id);
		
	}

	public String loadUsers() {
		
	userRep.deleteAll();
		
		userRep.save(new SMUser("Arun", Date.valueOf("2020-3-12")));
		userRep.save(new SMUser("Amit", Date.valueOf("2020-3-12")));
	    userRep.save(new SMUser("Saravan", Date.valueOf("2020-3-12")));
	    userRep.save(new SMUser("Amruthan", Date.valueOf("2020-3-12")));
	    userRep.save(new SMUser("Reddy v", Date.valueOf("2020-3-12")));
	            
		return "<html><body><h2>Welcome!! Dashboard users reloaded</h2></body></html>";
				}

	public  String deleteUserBtyId(Long userId) {

    try
    {
		
    	userRep.deleteById(userId);
    	return "User Deteted!";
    }catch (Exception e) {
    	return "User Deletion Failed";
    }
    
	}

	public SMUser createUser(SMUser user) {
		userRep.save(user);
		return user;
	}

	public Boolean deleteUserById(Long userId) {

		try{userRep.deleteById(userId);	return true;}catch (Exception e) {
return false;		}	
	}
}
