package com.bridgeit.restdemo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bridgeit.restdemo.model.Customer;

@Repository
public class CustomerDao {

	private static List<Customer> customers;
	
	static{
		
		customers=dummycustomers();
	}
	private static List dummycustomers()
	{
		List customers=new ArrayList();
		customers.add(new Customer(101,"ABC","MNP","abc@gmail.com"));
		customers.add(new Customer(102,"jack","pack","jack@gmail.com"));
		customers.add(new Customer(301,"lalu","yadav","lalu@gmail.com"));
		customers.add(new Customer(302,"munna","bhai","munna@gmail.com"));
		return customers;
	}
	
	public List<Customer> list()
	{
		System.out.println("list:"+customers);
		return customers;
		
	}
	
	public Customer get(int id) {
		System.out.println();
		for (Customer c : customers) {
			if (c.getId()==(id)) {
				return c;
			}
		}
		return null;
	}
	
	public void deleteUserById(int id)
	{
        
        for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext(); ) {
            Customer customers = iterator.next();
            if (customers.getId() == id) {
                iterator.remove();
            }
        }
    }
	
/*	public List updateCustomer(int id,Customer customer)
	{
	
				customers.add(customer);
				return customers;
		
	}
*/
	
	public Customer addCustomer(Customer customer)
	{
		System.out.println("Adding customers call....");
		customers.add(customer);
		System.out.println("Add list: "+customers);
		return customer;
		
	}

	public List updateCustomer(int id1, Customer customer) {

		for(Customer c: customers){
			if(c.getId()==id1)
			{		
				customer.setId(id1);
				customers.remove(c);
				customers.add(customer);
				return customers;
			}
		}
		
		return null;
	//	customers.add(customer);
	//	return customers;

		
	}
}
