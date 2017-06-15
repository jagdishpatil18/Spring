package com.bridgeit.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.Employee;
import com.bridgeit.model.User;
import com.bridgeit.service.UserServiceIntf;


@Controller
public class UserRegController {
	
	@Autowired
	private UserServiceIntf userserviceint; 
	
	@RequestMapping(value="/")
	public ModelAndView indexPage(HttpServletRequest req, HttpServletResponse resp) 
	{

			return new ModelAndView("signup");
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("users") User user, BindingResult results){
		System.out.println("register method");
		/*if(user.getPassword().equals("") || user.getEmailid().equals("") ||user.getName().equals("") ){*/
		if(results.hasErrors()){
			System.out.println("Password must feel");
			return new ModelAndView("signup");
		}
		else{
		userserviceint.registerUser(user);
		return new ModelAndView("redirect:login");
		}
	}
	

	@RequestMapping(value="/login")
	public ModelAndView LoginPage(HttpServletRequest req, HttpServletResponse resp) 
	{

			return new ModelAndView("login");
	}

	@RequestMapping(value="/loginuser", method=RequestMethod.POST)
	public ModelAndView Login(String emailid, String password,HttpServletRequest request,HttpServletResponse response){
		
		System.out.println(emailid+"   "+password);
		userserviceint.loginUser(emailid, password);	
		
		ModelAndView view=null;
		
		/*Object n=userserviceint.loginUser(emailid, password);
		
		System.out.println("return value of validationuser "+n);
		if(n!=null){
		view= new ModelAndView("loginUser");
		view.addObject("emailid", emailid);
		
		request.getSession().setAttribute("uid",n);*/
		
List<User> list=userserviceint.loginUser(emailid,password);
		
		if(list.size() > 0)
		{
			Iterator<User> iterator=list.iterator();
			while(iterator.hasNext())
			{
				User user=(User) iterator.next();
				int uid=user.getId();
				String email=user.getEmailid();
				System.out.println("uid for session :"+uid);
			/*	System.out.println("uid for session :"+email);*/
				request.getSession().setAttribute("uid",uid);
				request.getSession().setAttribute("email",email );
			}
		
			 view= new ModelAndView("redirect:Registrationpage");
		//	 view.addObject("emailid", emailid);
			 return view;
		}
			
	//		return view;
		
		else{
	//		return new ModelAndView("signup");
	
			view=new ModelAndView("signup");
			view.addObject("message", "Username/ Password wrong");
			
		}
		return view;
	}
	
	@RequestMapping(value="/Registrationpage")
	public ModelAndView loginpage(HttpServletRequest request)
	{
		int user1=(int) request.getSession().getAttribute("uid");
		String user=(String) request.getSession().getAttribute("email");
		System.out.println("Login by :"+user);
		return new ModelAndView("loginUser","emailid",user);
		
		
	}
	
	@RequestMapping(value="/Employee_Registration", method=RequestMethod.POST)
	public ModelAndView addEmployee(HttpServletRequest request,Employee employee)
	{
		
		int uid=(int) request.getSession().getAttribute("uid");
		System.out.println(uid);
		employee.setUid(uid);
		userserviceint.addEmployee(employee);
		return new ModelAndView("employee");
	}
	@RequestMapping(value="/EmployeeList", method=RequestMethod.GET)
	public ModelAndView listEmployee(HttpServletRequest request, HttpServletResponse response)
	{
		int uid=(int) request.getSession().getAttribute("uid");
		System.out.println("list emp uid :"+uid);
		List<Employee>emplist=userserviceint.listEmployee(uid);
		return new ModelAndView("employeelist","employeelist",emplist);
		
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		userserviceint.logoutUser(session);
		return new ModelAndView("redirect:login");
	
		
	}
	@RequestMapping(value="/update")
	public ModelAndView updatefor(@RequestParam("id") int eid)
	{
		List<Employee> emp=userserviceint.getEmployeebyId(eid);
		System.out.println("----------------------"+emp.toString());
		return new ModelAndView("updateEmployee","emprecord",emp );
	}
	
	@RequestMapping(value="/Employee_Update")
	public ModelAndView updateEmployee(Employee employee,HttpServletRequest request)
	{

		int uid=(int) request.getSession().getAttribute("uid");
		System.out.println("update by :"+uid);
		employee.setUid(uid);
		userserviceint.updateEmployee(employee);
		return new ModelAndView("redirect:EmployeeList");
		
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView getEmployeeforDelete(@RequestParam("id") int eid)
	{
		System.out.println("delete emp :"+eid);
		userserviceint.deleteEmployee(eid);
		return new ModelAndView("redirect:EmployeeList");
		
	}
}
