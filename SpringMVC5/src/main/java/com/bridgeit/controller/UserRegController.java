package com.bridgeit.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value={"/","/signup"})
	public ModelAndView indexPage(HttpServletRequest req, HttpServletResponse resp) 
	{
			//model.addAttribute();
			return new ModelAndView("signup", "user", new User());
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("user")User user, BindingResult results){
		System.out.println("register method");
		/*if(user.getPassword().equals("") || user.getEmailid().equals("") ||user.getName().equals("") ){*/
		if(results.hasErrors()){
			System.out.println("Password must feel");
			return new ModelAndView("signup", "user", user);
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
	//	userserviceint.loginUser(emailid, password);	
		
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
	
			view=new ModelAndView("login");
			view.addObject("message", "Username/ Password wrong");
			
		}
		return view;
	}
	
	@RequestMapping(value="/Registrationpage")
	public ModelAndView loginpage(HttpServletRequest request)
	{
		Integer user1=(Integer) request.getSession().getAttribute("uid");
		String user=(String) request.getSession().getAttribute("email");
		System.out.println("Login by :"+user);
		return new ModelAndView("loginUser","emailid",user);
		
		
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		userserviceint.logoutUser(session);
		return new ModelAndView("redirect:login");
	
		
	}
}
