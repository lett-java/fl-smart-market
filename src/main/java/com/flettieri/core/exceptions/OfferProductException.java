package com.flettieri.core.exceptions;

public class OfferProductException extends RuntimeException {

	private static final long serialVersionUID = 7993098441084698953L;

	public OfferProductException() {
		
	}
	
	public OfferProductException(String msg) {
		super(msg);
	}
}
