package com.nhncorp.edu.sample.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndGoView;

public class BoardUserEntryPoint  {
	private static final String LOGIN_URL = "../user/login.nhn";
	
	@RequestMapping
	public View redirect(HttpServletRequest request) {
		AlertAndGoView view = new AlertAndGoView();
		view.setDestUrl(LOGIN_URL);
		view.setMessage("로그인이 필요합니다");
		return view;
	}
}