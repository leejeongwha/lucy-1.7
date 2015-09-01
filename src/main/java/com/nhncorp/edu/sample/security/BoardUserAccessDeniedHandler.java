package com.nhncorp.edu.sample.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndBackView;

public class BoardUserAccessDeniedHandler {
	@RequestMapping("/**")
	public View defaultHandler() {
		AlertAndBackView view = new AlertAndBackView();
		view.setMessage("권한이 없습니다.");
		
		return view;
	}
}