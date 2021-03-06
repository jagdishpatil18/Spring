package com.bridgeit.DAO;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.Employee;
import com.bridgeit.model.User;

@Repository
//@Transactional
public class UserregDaoImpl implements UserRegIntface {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public ModelAndView registerUser(User user) {
		
		Session session=sessionFactory.getCurrentSession();
		try{
		session.save(user);
		}
		catch(Exception e){
		//	e.printStackTrace();
			return new ModelAndView("redirect:register");
		}
		System.out.println("saving user");
		return null;
	/*	Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();*/
			
	}

	@Override
	public List<User> loginUser(String emailid, String password) {
		
		Session session = sessionFactory.getCurrentSession();
		String qry="from User where emailid=:emailid and password=:password";
	    Query query=session.createQuery(qry);
		query.setParameter("emailid", emailid);
	    query.setParameter("password", password);
	//	Object n= query.uniqueResult();
	    List<User> list=query.list();
    	return list;
//		return n;
		
	}

	@Override
	public void logoutUser(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
	//	return new ModelAndView("redirect:login");
	}
	
}
