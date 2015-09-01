package com.nhncorp.edu.sample.security;

import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nhncorp.edu.sample.user.model.BoardUser;
import com.nhncorp.edu.sample.user.model.BoardUserPrincipal;
import com.nhncorp.edu.sample.user.model.LoginUserRepository;
import com.nhncorp.lucy.spring.security.SpringSecurityUserFactory;

public class BoardUserFactory implements SpringSecurityUserFactory<BoardUser> {
	private Provider<BoardUserPrincipal> provider;

	public Provider<BoardUserPrincipal> getProvider() {
		return provider;
	}

	public void setProvider(Provider<BoardUserPrincipal> provider) {
		this.provider = provider;
	}

	public BoardUserPrincipal getBoardUserPrincipal() {
		return provider.get();
	}

	@Override
	public BoardUser getAnonymousUser(HttpServletRequest req) {
		return new BoardUser();
	}

	@Override
	public BoardUserPrincipal getPrincipal(HttpServletRequest req) {
		BoardUserPrincipal boardUserPrincipal = getBoardUserPrincipal();
		return boardUserPrincipal.setHttpServletRequest(req);
	}

	@Override
	public BoardUser getUserFromPrincipal(Object principal) throws UsernameNotFoundException {
		if (principal == null || !BoardUserPrincipal.class.isAssignableFrom(principal.getClass())) {
			throw new UsernameNotFoundException("not acceptible principal: " + principal);
		}
		
		BoardUserPrincipal boardUserPrincipal = BoardUserPrincipal.class.cast(principal);
		
		final String id = boardUserPrincipal.getId();
		
		if(id == null) {
			throw new UsernameNotFoundException("일치하는 사용자 없음");
		}
		
		BoardUser boardUser = LoginUserRepository.getUser(id);
		
		if(boardUser == null) {
			throw new UsernameNotFoundException("일치하는 사용자 없음");
		}
		
		return boardUser;
	}
	
}