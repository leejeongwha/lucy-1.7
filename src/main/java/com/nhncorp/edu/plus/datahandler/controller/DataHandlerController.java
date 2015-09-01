package com.nhncorp.edu.plus.datahandler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.lucy.spring.core.data.DataHandler;
import com.nhncorp.lucy.spring.core.data.DataHandlerFactory;

@Controller
public class DataHandlerController {
	@RequestMapping("/plus/hello1")
	public ModelAndView hello1() throws Exception {
		ModelAndView mav = new ModelAndView("/plus/hello");
		
		DataHandler dataHandler = DataHandlerFactory.getDataHandler("default");
		
		mav.addObject("message", dataHandler.get("data1"));
		mav.addObject("message1", dataHandler.get("data2/elem1"));
		mav.addObject("message2", dataHandler.get("filepath"));
		return mav;
	}
	
	@RequestMapping("/plus/hello2")
	public ModelAndView hello2() throws Exception {
		ModelAndView mav = new ModelAndView("/plus/hello");
		
		DataHandler dataHandler = DataHandlerFactory.getDataHandler("data1");
		
		mav.addObject("message", dataHandler.get("spring"));
		return mav;
	}
}
