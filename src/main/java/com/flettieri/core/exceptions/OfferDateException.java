package com.flettieri.core.exceptions;

public class OfferDateException extends RuntimeException {

	private static final long serialVersionUID = 3353679360344434251L;
	
	public OfferDateException() {
		
	}
	
	public OfferDateException(String msg) {
		super(msg);
	}
}
