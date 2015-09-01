package com.nhncorp.edu.mvc.test.factory;

import com.nhncorp.edu.mvc.model.User;
import com.nhncorp.lucy.spring.mvc.attribute.RequestAttribute;

public class UserFactory {
	@RequestAttribute("user")
	public User getUser() {
		User user = new User();
		user.setName("anonymous");
		return user;
	}
}
