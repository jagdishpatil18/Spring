package com.bridgeit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.Employee;


@Repository
//@Transactional
public class EmployeeDaoImpl implements EmployeeDaoInterface{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public ModelAndView addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		try{
		session.save(employee);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:loginuser");
		}
		return null;
	}

	@Override
	public List<Employee> listEmployee(int uid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String query="from Employee where uid="+uid;
		Query query1=session.createQuery(query);
		//query1.setParameter("uid", uid);
		List<Employee> list=query1.list();
		return list;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		try{
			session.update(employee);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getEmployeebyId(int eid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String query="from Employee where eid="+eid;
		Query query1=session.createQuery(query);
		//query1.setParameter("uid", uid);
		List<Employee> list=query1.list();
		return list;
	}

	@Override
	public void deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		try{
		String query="Delete from Employee where eid="+eid;
		Query query1=session.createQuery(query);
		query1.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

}
