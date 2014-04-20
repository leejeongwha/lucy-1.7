package com.nhncorp.edu.mvc.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhncorp.edu.mvc.exception.MvcException;

@Controller
public class ExceptionController {
	@RequestMapping("/mvc/exception1")
	public void exception1() {
		throw new ArithmeticException();
	}
	
	@RequestMapping("/mvc/exception2")
	public void exception2() {
		throw new NullPointerException();
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException e) {
		return "mvc/exception";
	}
	
	@RequestMapping("/mvc/exception3")
	public void exception3() {
		throw new MvcException();
	}

}
