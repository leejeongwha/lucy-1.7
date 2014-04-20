package com.nhncorp.edu.mvc.hello.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component("hello2")
public class Hello2Controller implements Controller {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		logger.debug("ControllerBeanNameHandlerMapping TEST");

		String name = req.getParameter("name");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("message", name);

		return new ModelAndView("mvc/hello", model);
	}
}
