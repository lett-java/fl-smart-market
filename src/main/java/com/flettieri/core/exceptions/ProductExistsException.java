package com.flettieri.core.exceptions;

public class ProductExistsException extends RuntimeException {

	private static final long serialVersionUID = 8884518077798694708L;
	
	public ProductExistsException() {
		
	}
	
	public ProductExistsException(String msg) {
		super(msg);
	}
	
}
