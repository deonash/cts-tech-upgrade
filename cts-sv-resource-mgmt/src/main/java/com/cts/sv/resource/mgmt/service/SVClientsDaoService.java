package com.cts.sv.resource.mgmt.service;


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

import com.cts.sv.resource.mgmt.dao.SVClientsRepository;
import com.cts.sv.resource.mgmt.domain.SVCUser;


@Component
public class SVClientsDaoService {

	@Autowired
	SVClientsRepository userRep;	
	
	public List<SVCUser> getAllUsers()
	{
		return (List<SVCUser>) userRep.findAll();
	}
	
	public Optional<SVCUser> getUserById(Long id)
	{
		return userRep.findById(id);
		
	}

	public String loadUsers() {
		
	userRep.deleteAll();
		
		userRep.save(new SVCUser("Arun", Date.valueOf("2020-3-12")));
		userRep.save(new SVCUser("Amit", Date.valueOf("2020-3-12")));
	    userRep.save(new SVCUser("Saravan", Date.valueOf("2020-3-12")));
	    userRep.save(new SVCUser("Amruthan", Date.valueOf("2020-3-12")));
	    userRep.save(new SVCUser("Reddy v", Date.valueOf("2020-3-12")));
	            
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

	public SVCUser createUser(SVCUser user) {
		userRep.save(user);
		return user;
	}

	public Boolean deleteUserById(Long userId) {

		try{userRep.deleteById(userId);	return true;}catch (Exception e) {
return false;		}	
	}
}
