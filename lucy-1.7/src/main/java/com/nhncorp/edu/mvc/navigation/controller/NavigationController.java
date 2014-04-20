package com.nhncorp.edu.mvc.navigation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndBackView;
import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndCloseView;
import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndGoView;
import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndPostView;
import com.nhncorp.lucy.spring.mvc.view.navigation.ConfirmAndGoView;
import com.nhncorp.lucy.spring.mvc.view.navigation.ConfirmAndPostView;

@Controller
public class NavigationController {
	@RequestMapping("/mvc/nv1")
	public AlertAndBackView nv1() {
		AlertAndBackView view = new AlertAndBackView();
		view.setMessage("AlertAndBackView");
		return view;
	}
	
	@RequestMapping("/mvc/nv2")
	public AlertAndCloseView nv2() {
		AlertAndCloseView view = new AlertAndCloseView();
		view.setMessage("AlertAndCloseView");
		return view;
	}
	
	@RequestMapping("/mvc/nv3")
	public AlertAndGoView nv3() {
		AlertAndGoView view = new AlertAndGoView();
		view.setMessage("AlertAndGoView");
		view.setDestUrl("./nv");
		return view;
	}
	
	@RequestMapping("/mvc/nv4")
	public AlertAndPostView nv4() {
		AlertAndPostView view = new AlertAndPostView();
		view.setMessage("AlertAndPostView");
		view.setDestUrl("./nv");
		return view;
	}
	
	@RequestMapping("/mvc/nv5")
	public ConfirmAndGoView nv5() {
		ConfirmAndGoView view = new ConfirmAndGoView();
		view.setMessage("ConfirmAndGoView");
		view.setDestUrl("./nv");
		return view;
	}
	
	@RequestMapping("/mvc/nv6")
	public ConfirmAndPostView nv6() {
		ConfirmAndPostView view = new ConfirmAndPostView();
		view.setMessage("ConfirmAndPostView");
		view.setDestUrl("./nv");
		return view;
	}
	
	@RequestMapping("/mvc/nv")
	public String nv() {
		return "mvc/nv";
	}
}
