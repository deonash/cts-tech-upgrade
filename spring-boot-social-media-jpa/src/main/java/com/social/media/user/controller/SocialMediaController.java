package com.social.media.user.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.social.media.user.dao.UserRepository;
import com.social.media.user.domain.SMUser;
import com.social.media.user.service.SocialMediaDaoService;
import com.social.media.user.util.UserNotFoundException;



@RestController
public class SocialMediaController {
	
	@Autowired
	private SocialMediaDaoService service;
	@Autowired
	private MessageSource messageSource;
	
	private String appMode;

    @Autowired
    public SocialMediaController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    
	  @RequestMapping("/")
	    public String index(Model model){
	       
	        return "index";
	    }
	
	/**
	 * Load users
	 * @return
	 */
	@GetMapping(path = "/dashboard")
	public String loadUsers()
	{
	return service.loadUsers();
	}
	
	/**
	 * List all users
	 * @return
	 */
	@GetMapping(path = "/users")
	List<SMUser> dashboardUsers()
	{
		return (List<SMUser>) service.getAllUsers();//service.getAllUsers();
	}
	
	/**
	 * get user by id
	 * @param userId
	 * @return
	 */
	@GetMapping(path = "/users/{userId}")
	EntityModel<Optional<SMUser>> findUserById(@PathVariable Long userId)
	{
		Optional<SMUser> user = service.getUserById(userId);
		if(user.isEmpty() )
		{
			throw new UserNotFoundException("id : "+userId);
		}
		
		EntityModel<Optional<SMUser>> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).dashboardUsers());
		
		resource.add(linkTo.withRel("all-users"));
				
		
		return resource;
	}

	@PostMapping(path = "/users")
	ResponseEntity<Object> createUser(@Valid @RequestBody SMUser user)
	{
		SMUser userSaved = service.createUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri();
		return ResponseEntity.created(location).build()	;
			
	}
	@DeleteMapping(path = "/users/{userId}")
	Boolean deleteUserById(@PathVariable Long userId)
	{
		Boolean isdeleted = service.deleteUserById(userId);
		if(!isdeleted)
		{
			throw new UserNotFoundException("failed to delete : "+userId);
		}
		return isdeleted;
	}

}
