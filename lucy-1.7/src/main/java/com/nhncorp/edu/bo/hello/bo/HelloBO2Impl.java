package com.nhncorp.edu.bo.hello.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhncorp.edu.bo.hello.dao.HelloDAO;

@Service("helloBO2")
public class HelloBO2Impl implements HelloBO {
	
	@Autowired
	private HelloDAO helloDAO;

	@Override
	public String getMessage() {
		return helloDAO.getMessage();
	}

}
