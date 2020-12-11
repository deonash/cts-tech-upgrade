package com.cts.sv.resource.mgmt.controller;

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
import org.springframework.http.HttpStatus;
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

import com.cts.sv.resource.mgmt.dao.SVClientsRepository;
import com.cts.sv.resource.mgmt.domain.SVCUser;
import com.cts.sv.resource.mgmt.service.SVClientsDaoService;
import com.cts.sv.resource.mgmt.util.UserNotFoundException;



@RestController
public class SVClientsController {
	
	@Autowired
	private SVClientsDaoService service;
	@Autowired
	private MessageSource messageSource;
	
	private String appMode;

    @Autowired
    public SVClientsController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    
	  @RequestMapping("/")
	    public String index(Model model){
	       
	        return "index";
	    }
	  
	  
	  /*
	   * 
	   *  SVClients resource management api's
	   * 
	   */
	  
	  /* user auth */
	  
	  @PostMapping(path = "/auth/user")
		ResponseEntity<Object> authenticateUser(@Valid @RequestBody SVCUser user)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	
	  
	  /* create/update/delete client's resource request */
	  
	  @PostMapping(path = "/create/resource")
		ResponseEntity<Object> createResource(@Valid @RequestBody Resource resource)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  @PostMapping(path = "/update/resource")
		ResponseEntity<Object> updateResource(@Valid @RequestBody Resource resource)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  @DeleteMapping(path = "/delete/resource")
		ResponseEntity<Object> deleteResource(@Valid @RequestBody Resource resource)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  
/* create/update/delete client's resource request */
	  
	  @PostMapping(path = "/create/client")
		ResponseEntity<Object> createClient(@Valid @RequestBody Client client)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  @PostMapping(path = "/update/client")
		ResponseEntity<Object> updateClient(@Valid @RequestBody Client client)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  @DeleteMapping(path = "/delete/client")
		ResponseEntity<Object> deleteClient(@Valid @RequestBody Client client)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  
	  @PostMapping(path = "/create/crequest")
		ResponseEntity<Object> createClientRequest(@RequestBody ClientRequest clientRequest)
		{
			// todo
		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  @PostMapping(path = "/update/crequest")
		ResponseEntity<Object> updateClientRequest(@Valid @RequestBody ClientRequest clientRequest)
		{
			// todo
		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  @DeleteMapping(path = "/delete/crequest")
		ResponseEntity<Object> deleteClientRequest(@Valid @RequestBody ClientRequest clientRequst)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  
/* create/update/delete client's resource request */
	  
	  @PostMapping(path = "/create/empAssign")
		ResponseEntity<Object> createEmployeeAssignment(@Valid @RequestBody EmployeeAssignment client)
		{
			// todo
		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  @PostMapping(path = "/update/empAssign")
		ResponseEntity<Object> updateEmployeeAssignment(@Valid @RequestBody EmployeeAssignment client)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
		}
	  @DeleteMapping(path = "/delete/empAssign")
		ResponseEntity<Object> deleteEmployeeAssignment(@Valid @RequestBody EmployeeAssignment client)
		{
			// todo
		  		  return new ResponseEntity<Object>("Request completed", HttpStatus.OK);
				
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
	List<SVCUser> dashboardUsers()
	{
		return (List<SVCUser>) service.getAllUsers();//service.getAllUsers();
	}
	
	/**
	 * get user by id
	 * @param userId
	 * @return
	 */
	@GetMapping(path = "/users/{userId}")
	EntityModel<Optional<SVCUser>> findUserById(@PathVariable Long userId)
	{
		Optional<SVCUser> user = service.getUserById(userId);
		if(user.isEmpty() )
		{
			throw new UserNotFoundException("id : "+userId);
		}
		
		EntityModel<Optional<SVCUser>> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).dashboardUsers());
		
		resource.add(linkTo.withRel("all-users"));
				
		
		return resource;
	}

	@PostMapping(path = "/users")
	ResponseEntity<Object> createUser(@Valid @RequestBody SVCUser user)
	{
		SVCUser userSaved = service.createUser(user);
		
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
