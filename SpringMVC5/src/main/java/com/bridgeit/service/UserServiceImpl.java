package com.bridgeit.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.DAO.UserRegIntface;
import com.bridgeit.model.Employee;
import com.bridgeit.model.User;


@Service
//@Transactional
public class UserServiceImpl implements UserServiceIntf   {

	@Autowired
	private UserRegIntface userRegintf;
	
	@Override
	@Transactional
	public ModelAndView registerUser(User user) {
		
		return userRegintf.registerUser(user);
		
	}

	@Override
	@Transactional
	public List<User> loginUser(String emailid, String password) {
		return userRegintf.loginUser(emailid, password);
	//	return obj;
		
	}
	@Override
	public void logoutUser(HttpSession session) {
		// TODO Auto-generated method stub
		 userRegintf.logoutUser(session);
	}

}
