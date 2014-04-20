package com.nhncorp.edu.mvc.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	@RequestMapping("/mvc/view1")
	public String view1() {
		return "mvc/view";
	}

	@RequestMapping("/mvc/view2")
	public ModelAndView view2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mvc/view");
		return mav;
	}
	
	@RequestMapping("/mvc/view3")
	public ModelAndView view3(){
	  ModelAndView mav = new ModelAndView();
	  return mav;
	}
	
	@RequestMapping("/mvc/view4")
	public ModelAndView view4(){
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("redirect:/mvc/redirect");
	  return mav;
	}
	
	@RequestMapping("/mvc/view5")
	public String view5(){
		return "customView";
	}
	
	@RequestMapping("/mvc/redirect")
	public void redirect(){
	}
}
