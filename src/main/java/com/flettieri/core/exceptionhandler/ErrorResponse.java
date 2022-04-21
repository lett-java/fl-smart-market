package com.flettieri.core.exceptionhandler;

import java.util.List;

import lombok.Getter;

@Getter
public class ErrorResponse {

    public ErrorResponse(String message, int code, String status, String objectName,
			List<ErrorObject> errors) {
				this.message = message;
				this.code = code;
				this.status = status;
				this.objectName = objectName;
				this.errors = errors;
	}
    
	private final String message;
    private final int code;
    private final String status;
    private final String objectName;
    private final List<ErrorObject> errors;
}
