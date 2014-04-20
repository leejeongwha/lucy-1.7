package com.nhncorp.edu.sample.user.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class BoardUser implements UserDetails {
	private static final GrantedAuthority ADMIN_AUTHRITY = new GrantedAuthorityImpl(Role.ADMIN.toString());
	private static final GrantedAuthority MEMBER_AUTHRITY = new GrantedAuthorityImpl(Role.MEMBER.toString());

	private Set<GrantedAuthority> authrities = new HashSet<GrantedAuthority>();

	private String id;
	private String passwd;
	private String userName;
	private int age;
	private String role;

	public BoardUser() {

	}

	public BoardUser(BoardUserPrincipal header) {
		this.id = header.getId();

		authrities.add(getGrantedAuthority(this.role));
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return Collections.unmodifiableSet(authrities);
	}
	
	private GrantedAuthority getGrantedAuthority(String role) {
		Role roleType = Role.valueOf(role);
		
		if(roleType == Role.ADMIN) {
			return ADMIN_AUTHRITY;
		} else {
			return MEMBER_AUTHRITY;
		}
	}
	
	public void generateAuthority() {
		authrities.add(getGrantedAuthority(this.role));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getPassword() {
		return passwd;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
