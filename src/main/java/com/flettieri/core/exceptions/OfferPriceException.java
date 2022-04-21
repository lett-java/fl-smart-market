package com.flettieri.core.exceptions;

public class OfferPriceException extends RuntimeException {

	private static final long serialVersionUID = 3039840416457074152L;
	
	public OfferPriceException() {
		
	}
	
	public OfferPriceException(String msg) {
		super(msg);
	}
}
