package com.bridgeit.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.Employee;
import com.bridgeit.model.User;

public interface UserRegIntface {
	
	public ModelAndView registerUser(User user);
	public List<User> loginUser(String emailid, String password);
	public void logoutUser(HttpSession session);
}
