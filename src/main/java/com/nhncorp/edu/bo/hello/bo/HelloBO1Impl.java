package com.nhncorp.edu.bo.hello.bo;

import org.springframework.stereotype.Service;

@Service("helloBO1")
public class HelloBO1Impl implements HelloBO{

	@Override
	public String getMessage() {
		return "Hello World!!";
	}

}
