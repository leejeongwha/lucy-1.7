package com.nhncorp.edu.security;

import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nhncorp.edu.security.model.LoginUserRepository;
import com.nhncorp.edu.security.model.User;
import com.nhncorp.edu.security.model.UserPrincipal;
import com.nhncorp.lucy.spring.security.SpringSecurityUserFactory;

public class UserFactory implements SpringSecurityUserFactory<User> {
	@Override
	public User getAnonymousUser(HttpServletRequest req) {
		return new User();
	}

	@Override
	public UserPrincipal getPrincipal(HttpServletRequest req) {
		UserPrincipal userPrincipal = getUserPrincipal();
		return userPrincipal.setHttpServletRequest(req);
	}

	@Override
	public User getUserFromPrincipal(Object principal) throws UsernameNotFoundException {
		if (principal == null || !UserPrincipal.class.isAssignableFrom(principal.getClass())) {
			throw new UsernameNotFoundException("not acceptible principal: " + principal);
		}
		
		UserPrincipal userPrincipal = UserPrincipal.class.cast(principal);
		
		final String id = userPrincipal.getId();
		
		if(id == null) {
			throw new UsernameNotFoundException("일치하는 사용자 없음");
		}
		
		User user = LoginUserRepository.getUser(id);
		
		if(user == null) {
			throw new UsernameNotFoundException("일치하는 사용자 없음");
		}
		
		return user;
	}
	
	private Provider<UserPrincipal> provider;

	public Provider<UserPrincipal> getProvider() {
		return provider;
	}

	public void setProvider(Provider<UserPrincipal> provider) {
		this.provider = provider;
	}

	public UserPrincipal getUserPrincipal() {
		return provider.get();
	}
	
}