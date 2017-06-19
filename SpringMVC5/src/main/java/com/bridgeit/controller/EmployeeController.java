package com.bridgeit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.Employee;
import com.bridgeit.service.EmployeeServiceInterface;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServiceInterface employeeServiceInterface;

	

	@RequestMapping(value="/Employee_Registration", method=RequestMethod.POST)
	public ModelAndView addEmployee(HttpServletRequest request,Employee employee)
	{
		
		Integer uid=(Integer) request.getSession().getAttribute("uid");
		System.out.println(uid);
		employee.setUid(uid);
		employeeServiceInterface.addEmployee(employee);
		return new ModelAndView("employee");
	}
	@RequestMapping(value="/EmployeeList", method=RequestMethod.GET)
	public ModelAndView listEmployee(HttpServletRequest request, HttpServletResponse response)
	{
		Integer uid=(Integer) request.getSession().getAttribute("uid");
		System.out.println("list emp uid :"+uid);
		List<Employee>emplist=employeeServiceInterface.listEmployee(uid);
		return new ModelAndView("employeelist","employeelist",emplist);
		
	}

	@RequestMapping(value="/update")
	public ModelAndView updatefor(@RequestParam("id") int eid)
	{
		List<Employee> emp=employeeServiceInterface.getEmployeebyId(eid);
		System.out.println("----------------------"+emp.toString());
		return new ModelAndView("updateEmployee","emprecord",emp );
	}
	
	@RequestMapping(value="/Employee_Update")
	public ModelAndView updateEmployee(Employee employee,HttpServletRequest request)
	{

		Integer uid=(Integer) request.getSession().getAttribute("uid");
		System.out.println("update by :"+uid);
		employee.setUid(uid);
		employeeServiceInterface.updateEmployee(employee);
		return new ModelAndView("redirect:EmployeeList");
		
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView getEmployeeforDelete(@RequestParam("id") int eid)
	{
		System.out.println("delete emp :"+eid);
		employeeServiceInterface.deleteEmployee(eid);
		return new ModelAndView("redirect:EmployeeList");
		
	}

	
}
