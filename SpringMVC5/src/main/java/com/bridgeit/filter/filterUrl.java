package com.bridgeit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

/**
 * Servlet Filter implementation class filterUrl
 */
public class filterUrl implements Filter {

    
    public filterUrl() {
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}


		public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest request2=(HttpServletRequest) request;
		HttpServletResponse response2=(HttpServletResponse) response;
		
		HttpSession   session= request2.getSession(false);
		Integer sessionid=(Integer) session.getAttribute("uid");
		if(sessionid==null)
		{
			response2.sendRedirect("login");
			
		}
		else{
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
	}

	
}
