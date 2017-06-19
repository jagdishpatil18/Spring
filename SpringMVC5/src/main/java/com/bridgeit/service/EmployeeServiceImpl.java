package com.bridgeit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.DAO.EmployeeDaoInterface;
import com.bridgeit.model.Employee;

@Service
//@Transactional
public class EmployeeServiceImpl implements EmployeeServiceInterface {

	@Autowired
	EmployeeDaoInterface employeedao;
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeedao.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> listEmployee(int uid) {
		// TODO Auto-generated method stub
		return employeedao.listEmployee(uid);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeedao.updateEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> getEmployeebyId(int eid) {
		// TODO Auto-generated method stub
		return employeedao.getEmployeebyId(eid);
	}

	@Override
	@Transactional
	public void deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		employeedao.deleteEmployee(eid);
	}

}
