package com.nhncorp.edu.bo.hello.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDAOImpl implements HelloDAO {
	
	@Override
	public String getMessage() {
		return "Hello World!!";
	}

}
