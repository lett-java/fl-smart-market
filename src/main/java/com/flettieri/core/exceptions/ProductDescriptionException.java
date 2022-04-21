package com.flettieri.core.exceptions;

public class ProductDescriptionException extends RuntimeException {

	private static final long serialVersionUID = -6526582643609213486L;

	public ProductDescriptionException() {
		
	}
	
	public ProductDescriptionException(String msg) {
		super(msg);
	}
	
}
