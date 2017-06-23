package com.bridgeit.errorpages.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bridgeit.errorpages.exception.CustomGenericException;

public class CustomerController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		throw new CustomGenericException("E888", "Sorry for inconvinience");

	  }
	}


