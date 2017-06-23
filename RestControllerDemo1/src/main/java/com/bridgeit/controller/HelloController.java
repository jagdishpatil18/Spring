package com.bridgeit.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.model.Message;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String welcome()
	{
		return "Welcome in RestController Demo";
		
	}
	
	@RequestMapping("/hello/{name}")
	public Message HelloWorld(@PathVariable String name)
	{
		Message message=new Message(name,"Hello" + name);
		
		
		return message;
		
	}
}
