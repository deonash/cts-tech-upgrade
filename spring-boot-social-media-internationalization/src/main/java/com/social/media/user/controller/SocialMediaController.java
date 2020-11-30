package com.social.media.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.social.media.user.User;


@RestController
public class SocialMediaController {
	
	@Autowired
	private SocialMediaDaoService service;
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/users")
	List<User> dashboardUsers()
	{
		return service.getAllUsers();
	}
	
	@GetMapping(path = "/dashboard")
	public String welcomeUser(@RequestHeader(name="accept-language", required=false) Locale locale)
	{
		return messageSource.getMessage("social.media.message.welcome",null, locale);
	}
	
	@GetMapping(path = "/users/{userId}")
	EntityModel<User> findUserById(@PathVariable Integer userId)
	{
		User user = service.getUserById(userId);
		if(user == null)
		{
			throw new UserNotFoundException("id : "+userId);
		}
		
		EntityModel<User> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).dashboardUsers());
		
		resource.add(linkTo.withRel("all-users"));
				
		
		return resource;
	}

	@PostMapping(path = "/users")
	ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		User userSaved = service.createUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri();
		return ResponseEntity.created(location).build()	;
			
	}
	@DeleteMapping(path = "/users/{userId}")
	User deleteUserById(@PathVariable Integer userId)
	{
		User user = service.deleteUserById(userId);
		if(user == null)
		{
			throw new UserNotFoundException("id : "+userId);
		}
		return user;
	}

}
