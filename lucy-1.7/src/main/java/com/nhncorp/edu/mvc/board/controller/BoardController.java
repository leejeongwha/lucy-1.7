package com.nhncorp.edu.mvc.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/mvc/boardDefault")
	public String boardDefault() {
		logger.debug("boardDefault TEST");
		
		return "mvc/board";
	}
	
	@RequestMapping(value="/mvc/board", method=RequestMethod.GET)
	public String boardGet() {
		logger.debug("boardGet TEST");
		
		return "mvc/board";
	}
	
	@RequestMapping(value="/mvc/board", method=RequestMethod.POST)
	public String boardPost() {
		logger.debug("boardPost TEST");
		
		return "mvc/board";
	}
	
	@RequestMapping(value="/mvc/board", method=RequestMethod.GET, params={ "m=boardMethod" })
	public String boardMethod() {
		logger.debug("boardMethod TEST");
		
		return "mvc/board";
	}
}
