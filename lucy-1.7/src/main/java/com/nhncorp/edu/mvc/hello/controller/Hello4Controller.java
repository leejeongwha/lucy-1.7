package com.nhncorp.edu.mvc.hello.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Hello4Controller implements Controller {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug("SimpleUrlHandlerMapping TEST");

		String name = request.getParameter("name");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("message", name);

		return new ModelAndView("mvc/hello", model);
	}

}
