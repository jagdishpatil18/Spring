package com.bridgeit.service;

import java.util.List;

import com.bridgeit.model.Employee;

public interface EmployeeServiceInterface {

	public void addEmployee(Employee employee);
	public List<Employee> listEmployee(int uid);
	public void updateEmployee(Employee employee);
	public List<Employee> getEmployeebyId(int eid);
	public void deleteEmployee(int eid);
}
