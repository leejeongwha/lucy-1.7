package com.nhncorp.edu.mvc.model.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.edu.mvc.model.User;

@Controller
public class ModelController {
	@RequestMapping("/mvc/model1")
	public ModelAndView model1() {
		ModelAndView mav = new ModelAndView("mvc/model1");

		User user = new User();
		user.setName("user");

		mav.addObject("userInfo", user);
		return mav;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/mvc/model2")
	public Map model2() {
		User user = new User();
		user.setName("user");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userInfo", user);

		return map;
	}
	
	@RequestMapping("/mvc/model3")
	public ModelMap model3() {
		User user = new User();
		user.setName("user");

		ModelMap map = new ModelMap();
		map.addAttribute("userInfo", user);

		return map;
	}

	@RequestMapping("/mvc/model4")
	public Model model4() {
		User user = new User();
		user.setName("user");

		ExtendedModelMap model = new ExtendedModelMap();
		model.addAttribute("userInfo", user);

		return model;
	}
}
