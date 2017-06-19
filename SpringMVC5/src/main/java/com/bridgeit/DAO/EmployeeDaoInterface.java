package com.bridgeit.DAO;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.Employee;

public interface EmployeeDaoInterface {

	public ModelAndView addEmployee(Employee employee);
	public List<Employee> listEmployee(int uid);
	public void updateEmployee(Employee employee);
	public List<Employee> getEmployeebyId(int eid);
	public void deleteEmployee(int eid);

}
