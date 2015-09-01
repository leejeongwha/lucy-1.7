package com.nhncorp.edu.mvc.excercise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhncorp.edu.mvc.excercise.model.JSONMember;
import com.nhncorp.edu.mvc.excercise.model.XMLMember;

@Controller
public class ExcerciseController {
	@RequestMapping("/mvc/json1")
	@ResponseBody
	public JSONMember json1() {
		JSONMember member = new JSONMember();
		member.setId("id");
		member.setName("name");
		return member;
	}
	
	@RequestMapping("/mvc/json2")
	public String json2(Model model) {
		JSONMember member = new JSONMember();
		member.setId("id");
		member.setName("name");
		
		model.addAttribute("", member);
		return "jsonView";
	}
	
	@RequestMapping("/mvc/xml1")
	@ResponseBody
	public XMLMember xml1() {
		XMLMember member = new XMLMember();
		member.setId("id");
		member.setName("name");
		return member;
	}
	
	@RequestMapping("/mvc/xml2")
	public String xml2(Model model) {
		XMLMember member = new XMLMember();
		member.setId("id");
		member.setName("name");

		model.addAttribute(member);
		return "xmlView";
	}
	
}
