package com.nhncorp.edu.mvc.test.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.edu.mvc.model.User;
import com.nhncorp.lucy.spring.mvc.attribute.RequestAttribute;

@Controller
public class TestController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/mvc/test1")
	public ModelAndView test1(@RequestParam(value="name", required=false) String name) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("message", name);

	  return new ModelAndView("mvc/test", model);
	}
	
	@RequestMapping("/mvc/test2")
	public ModelAndView test2(@RequestParam(value="name", required=true, defaultValue="test2") String name) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("message", name);

	  return new ModelAndView("mvc/test", model);
	}
	
	@RequestMapping("/mvc/test3/{name}")
	public ModelAndView test3(@PathVariable String name) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("message", name);

	  return new ModelAndView("mvc/test", model);
	}
	
	@ModelAttribute("message")
	public String getMessage() {
		return "test4";
	}
	
	@RequestMapping("/mvc/test4")
	public ModelAndView test4() {
	  Map<String, Object> model = new HashMap<String, Object>();

	  return new ModelAndView("mvc/test", model);
	}
	
	@RequestMapping("/mvc/test5")
	public ModelAndView test5(@ModelAttribute User user) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("message", user.getName());

	  return new ModelAndView("mvc/test", model);
	}
	
	@RequestMapping("/mvc/test6")
	public ModelAndView test6(@RequestAttribute("user") User user) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("message", user.getName());

	  return new ModelAndView("mvc/test", model);
	}
	
	@RequestMapping("/mvc/test7")
	@ResponseBody
	public String test7(){
		return "<html>@ResponseBody</html>";
	}
	
	@RequestMapping("/mvc/test8")
	@ResponseBody
	public String test8(){
		String helloWorld = "helloWorld";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		
		HttpEntity<String> entity = new HttpEntity<String>(helloWorld, headers);
		
		RestTemplate template = new RestTemplate();
		template.postForLocation("http://localhost:8080/lucy-1.7/mvc/requestBody", entity);
		
		return "<htm>@ResponseBody</html>";
	}
	
	@RequestMapping("/mvc/requestBody")
	@ResponseBody
	public String requestBody(@RequestBody String body){
		logger.debug("requestBody " + body);
		
		return "<html>@ResponseBody</html>";
	}
	
	@RequestMapping("/mvc/test9")
	public ModelAndView test9(Date date) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("message", date);

		return new ModelAndView("mvc/test", model);
	}
}
