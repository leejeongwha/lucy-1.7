package com.nhncorp.edu.sample.user.model;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class BoardUserPrincipal implements Serializable {
	private static final long serialVersionUID = 7314493707961676869L;
	
	private String id;
	
	public BoardUserPrincipal() {
	}
	
	public BoardUserPrincipal setHttpServletRequest(HttpServletRequest req)  {
		this.id = req.getParameter("id");
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}