package com.nhncorp.edu.security.model;

import java.util.HashMap;
import java.util.Map;

public class LoginUserRepository {
	private static Map<String, User> userRepository = new HashMap<String, User>();
	
	public static User getUser(String id) {
		return userRepository.get(id);
	}
	
	public static void login(User user) {
		user.generateAuthority();
		userRepository.put(user.getId(), user);
	}
	
	public static void logout(User user) {
		userRepository.remove(user);
	}
	
	public static void logout(String id) {
		userRepository.remove(userRepository.get(id));
	}
}
