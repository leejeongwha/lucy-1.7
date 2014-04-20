package com.nhncorp.edu.sample.user;

public class InvalidUserException extends Exception {
	private static final long serialVersionUID = -8437836456731437898L;

	public InvalidUserException(String message) {
		super(message);
	}
}
