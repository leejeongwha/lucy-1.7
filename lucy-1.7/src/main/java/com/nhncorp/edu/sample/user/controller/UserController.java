package com.nhncorp.edu.sample.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.nhncorp.edu.sample.user.InvalidUserException;
import com.nhncorp.edu.sample.user.bo.UserBO;
import com.nhncorp.edu.sample.user.model.BoardUser;
import com.nhncorp.edu.sample.user.model.LoginUserRepository;
import com.nhncorp.edu.sample.user.model.Role;
import com.nhncorp.lucy.spring.core.web.helper.PagerInfo;
import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndGoView;
import com.nhncorp.lucy.spring.mvc.view.navigation.AlertAndPostView;

@Controller
@RequestMapping("/sample/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserBO bo;
	
	@RequestMapping(value="/login.nhn", method=RequestMethod.GET)
	public String login() throws Exception {
		return "/user/login";
	}
	
	@RequestMapping(value="/login.nhn", method=RequestMethod.POST)
	public View login(String id, String passwd) throws Exception {
		logger.info(id);
		logger.info(passwd);
		
		BoardUser boardUser = bo.login(id, passwd);
		
		if(boardUser != null) {
			LoginUserRepository.login(boardUser);
			
			AlertAndPostView view = new AlertAndPostView();
			view.setMessage(boardUser.getUsername() + "님 환영합니다.");
			view.setDestUrl("../board/list.nhn");
			view.addParam("id", id);
			
			return view;
		} else {
			throw new InvalidUserException("사용자 정보가 없습니다.");
		}
	}
	
	@RequestMapping(value="/logout.nhn")
	public View logout(String id) throws Exception {
		LoginUserRepository.logout(id);

		AlertAndGoView view = new AlertAndGoView();
		view.setMessage("로그아웃되었습니다.");
		view.setDestUrl("../user/login.nhn");
		
		return view;
	}
	
	@RequestMapping(value="/join.nhn", method=RequestMethod.GET)
	public String join() throws Exception {
		return "/user/join";
	}
	
	@RequestMapping(value="/join.nhn", method=RequestMethod.POST)
	public View join(HttpServletResponse response, BoardUser user) throws Exception {
		user.setRole(Role.MEMBER.toString());
		bo.join(user);
		LoginUserRepository.login(user);
		
		AlertAndPostView view = new AlertAndPostView();
		view.setMessage(user.getUsername() + "님 환영합니다. 가입을 완료하였습니다.");
		view.setDestUrl("../board/list.nhn");
		view.addParam("id", user.getId());
		
		return view;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/manage.nhn")
	public ModelAndView manage(HttpServletRequest req, String id, @RequestParam(value="page", required=true, defaultValue="1") String page) throws Exception {
		ModelAndView mav = new ModelAndView("/user/manage");
		
		int totalSize = bo.getUserCount();
		PagerInfo pagerInfo = new PagerInfo(req, "user", totalSize);
		pagerInfo.setPage(Integer.parseInt(page));
		pagerInfo.setQueryString("id=" + id);
		
		List<BoardUser> userList = null;
		
		if (totalSize > 0) {
			int from = pagerInfo.getStartRownum();
			int to = pagerInfo.getEndRownum();

			userList = bo.getUserList((from - 1), (to - from + 1));
		}
		
		mav.addObject("userList", userList);
		
		return mav;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/deleteUser.nhn")
	public View deleteUser(String id, String userId) throws Exception {
		bo.deleteUser(userId);
		LoginUserRepository.logout(userId);
		
		AlertAndPostView view = new AlertAndPostView();
		view.setMessage("삭제되었습니다.");
		view.setDestUrl("./manage.nhn");
		view.addParam("id", id);
		
		return view;
	}
	
	@ExceptionHandler(BindException.class)
	public ModelAndView bindError() throws Exception {
		ModelAndView mav = new ModelAndView("/user/bindError");
		mav.addObject("message", "입력값이 잘못되었습니다.");
		return mav;
	}
	
	@ExceptionHandler(InvalidUserException.class)
	public ModelAndView invalidUser(InvalidUserException ex) throws Exception {
		ModelAndView mav = new ModelAndView("/user/bindError");
		mav.addObject("message", ex.getMessage());
		return mav;
	}
}
