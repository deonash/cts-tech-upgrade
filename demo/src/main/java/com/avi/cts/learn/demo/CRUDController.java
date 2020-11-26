package com.avi.cts.learn.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUDController {
	
	@GetMapping(path="/crud")
	CRUDBean crudBean()
	{
		return new CRUDBean("Initialising CRUD Bean");
	}
	@GetMapping(path = "/home")
	String crudHome()
	{
		return "<html><body><div> <h2>Welcome to CRUD HOME</h2></div></body></html>";
	}
	
	@GetMapping(path = "/services")
	String crudServices()
	{
		return "Welcome to CRUD SERVICES";
	}
	
	@GetMapping(path = "/apis")
	String sayHi()
	{
		return "Welcome to CRUD API's";
	}

}
