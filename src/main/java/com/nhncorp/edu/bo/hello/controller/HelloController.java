package com.nhncorp.edu.bo.hello.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.edu.bo.hello.bo.HelloBO;

@Controller
public class HelloController {
	@Resource(name = "helloBO1")
	private HelloBO helloBO1;
	
	@RequestMapping("/bo/hello1")
	public ModelAndView hello1() throws Exception {
		ModelAndView mav = new ModelAndView("/bo/hello");
		mav.addObject("message", helloBO1.getMessage());
		return mav;
	}
	
	@Resource(name = "helloBO2")
	private HelloBO helloBO2;
	
	@RequestMapping("/bo/hello2")
	public ModelAndView hello2() throws Exception {
		ModelAndView mav = new ModelAndView("/bo/hello");
		mav.addObject("message", helloBO2.getMessage());
		return mav;
	}
}
