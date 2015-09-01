package com.nhncorp.edu.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class MvcException extends RuntimeException {
	private static final long serialVersionUID = -571920936546671111L;
}
