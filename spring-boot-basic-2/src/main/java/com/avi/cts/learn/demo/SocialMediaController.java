package com.avi.cts.learn.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SocialMediaController {
	
	@GetMapping(path="/dashboard")
	SMedia crudBean()
	{
		return new SMedia("Initialising Dashboard !!");
	}
	@GetMapping(path = "/dashboard/{user}")
	String crudHome(@PathVariable String user)
	{
		return "<html><body><div> Welcome to SMedia : <h2>"+ user + "</h2></div></body></html>";
	}
	
	@GetMapping(path = "/dashboard/services")
	String crudServices()
	{
		return "Welcome to SMedia SERVICES";
	}
	
	@GetMapping(path = "/dashboard/apis")
	String sayHi()
	{
		return "Welcome to SMedia API's";
	}

}
