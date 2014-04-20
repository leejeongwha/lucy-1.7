package com.nhncorp.edu.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.edu.security.model.LoginUserRepository;
import com.nhncorp.edu.security.model.User;
import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndPostView;

@Controller
public class SecurityController {
	@RequestMapping(value="/security/login", method=RequestMethod.GET)
	public ModelAndView login() throws Exception {
		ModelAndView mav = new ModelAndView("/security/login");
		return mav;
	}
	
	@RequestMapping(value="/security/login", method=RequestMethod.POST)
	public AlertAndPostView login(User user) throws Exception {
		LoginUserRepository.login(user);
		
		AlertAndPostView view = new AlertAndPostView();
		view.setMessage(user.getUsername() + "님 환영합니다.");
		view.setDestUrl("./menu");
		view.addParam("id", user.getId());
		return view;
	}
	
	@RequestMapping("/security/menu")
	public Model menu(Model model, String id) throws Exception {
		model.addAttribute("id", id);
		return model;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/security/admin")
	public void admin() throws Exception {
	}
	
	@PreAuthorize("hasRole('MEMBER')")
	@RequestMapping("/security/member")
	public void member() throws Exception {
	}
}
