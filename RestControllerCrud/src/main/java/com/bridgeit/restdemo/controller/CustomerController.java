package com.bridgeit.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.restdemo.dao.CustomerDao;
import com.bridgeit.restdemo.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerDao CustomerDao;
	
	@RequestMapping("/")
	public String welcome()
	{
		return "Hii, Welcome ino Customer Support ";
		
	}
	
	//@RequestMapping("/customers")
	@GetMapping("/customers")
	public List getAllCustomer()
	{
		
		return CustomerDao.list();
		
		
	}
	
	
	//@RequestMapping("/customers/{id}")
	@GetMapping("customers/{id}")
	public String getCustomer(@PathVariable("id")int id)
	{
		Customer customer=CustomerDao.get(id);
		return customer.toString();
	}
	
	@DeleteMapping("customers/{id}")
	public List deleteCustomer(@PathVariable("id")int id)
	{
		Customer customer=CustomerDao.get(id);
		CustomerDao.deleteUserById(id);
		return CustomerDao.list();
	}
	
	@PutMapping("/updatecustomers/{id}")
	public void updateCustomer(@PathVariable("id")int id, @RequestBody Customer customer )
	{
		Customer customer1=CustomerDao.get(id);
		int id1=(int) customer1.getId();
		CustomerDao.updateCustomer(id1,customer);
	//	return CustomerDao.list();
		
		
	}
	
	//@PostMapping("/addcustomers")
	@RequestMapping(value="/addcustomers", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List create(@RequestBody Customer customer) {
	//	Customer customer2=(Customer) CustomerDao.list();
		System.out.println(customer.getFirstname());
		CustomerDao.addCustomer(customer);
		return CustomerDao.list();
	}
	
	
}
