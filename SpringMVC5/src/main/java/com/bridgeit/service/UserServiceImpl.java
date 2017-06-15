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
public class UserServiceImpl implements UserServiceIntf   {

	@Autowired
	private UserRegIntface userRegintf;
	
	@Override
	@Transactional
	public ModelAndView registerUser(User user) {
		
		return userRegintf.registerUser(user);
		
	}

	@Override
	public List<User> loginUser(String emailid, String password) {
		return userRegintf.loginUser(emailid, password);
	//	return obj;
		
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 userRegintf.addEmployee(employee);
	}

	@Override
	public List<Employee> listEmployee(int uid) {
		// TODO Auto-generated method stub
		
		
		return userRegintf.listEmployee(uid);
	}

	@Override
	public void logoutUser(HttpSession session) {
		// TODO Auto-generated method stub
		 userRegintf.logoutUser(session);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		userRegintf.updateEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeebyId(int eid) {
		return userRegintf.getEmployeebyId(eid);
	}

	@Override
	public void deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		userRegintf.deleteEmployee(eid);
	}

	

	

		
		

}
