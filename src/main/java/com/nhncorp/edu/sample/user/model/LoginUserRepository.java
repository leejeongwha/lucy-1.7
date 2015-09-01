package com.nhncorp.edu.sample.user.model;

import java.util.HashMap;
import java.util.Map;

public class LoginUserRepository {
	private static Map<String, BoardUser> userRepository = new HashMap<String, BoardUser>();
	
	public static BoardUser getUser(String id) {
		return userRepository.get(id);
	}
	
	public static void login(BoardUser user) {
		user.generateAuthority();
		userRepository.put(user.getId(), user);
	}
	
	public static void logout(BoardUser user) {
		userRepository.remove(user);
	}
	
	public static void logout(String id) {
		userRepository.remove(userRepository.get(id));
	}
}
