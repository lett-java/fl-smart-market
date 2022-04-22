package com.flettieri.core.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.flettieri.core.exceptions.AnnouncerException;
import com.flettieri.core.exceptions.OfferDateException;
import com.flettieri.core.exceptions.OfferPriceException;
import com.flettieri.core.exceptions.OfferProductException;
import com.flettieri.core.exceptions.ProductDescriptionException;
import com.flettieri.core.exceptions.ProductExistsException;
import com.flettieri.core.exceptions.ProductNameException;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {
    
	@ExceptionHandler(ProductNameException.class)
    public ResponseEntity<StandardError> productNameException(ProductNameException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(
        		System.currentTimeMillis(), 
        		status.value(), 
        		"Name não inserido.", 
        		e.getMessage(), 
        		request.getRequestURI());
        
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ProductDescriptionException.class)
    public ResponseEntity<StandardError> productDescriptionException(ProductDescriptionException e, HttpServletRequest request) {
    	
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	StandardError err = new StandardError(
    			System.currentTimeMillis(), 
    			status.value(), 
    			"Description não inserido.", 
    			e.getMessage(), 
    			request.getRequestURI());
    	
    	return ResponseEntity.status(status).body(err);
    }
    
    @ExceptionHandler(AnnouncerException.class)
    public ResponseEntity<StandardError> announcerException(AnnouncerException e, HttpServletRequest request) {
    	
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	StandardError err = new StandardError(
    			System.currentTimeMillis(), 
    			status.value(), 
    			"Announcer não inserido.", 
    			e.getMessage(), 
    			request.getRequestURI());
    	
    	return ResponseEntity.status(status).body(err);
    }
    
    @ExceptionHandler(OfferDateException.class)
    public ResponseEntity<StandardError> offerDateException(OfferDateException e, HttpServletRequest request) {
    	
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	StandardError err = new StandardError(
    			System.currentTimeMillis(), 
    			status.value(), 
    			"Date não inserido.", 
    			e.getMessage(), 
    			request.getRequestURI());
    	
    	return ResponseEntity.status(status).body(err);
    }
    
    @ExceptionHandler(OfferPriceException.class)
    public ResponseEntity<StandardError> offerPriceException(OfferPriceException e, HttpServletRequest request) {
    	
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	StandardError err = new StandardError(
    			System.currentTimeMillis(), 
    			status.value(), 
    			"Price não inserido.", 
    			e.getMessage(), 
    			request.getRequestURI());
    	
    	return ResponseEntity.status(status).body(err);
    }
    
    @ExceptionHandler(OfferProductException.class)
    public ResponseEntity<StandardError> offerProductException(OfferProductException e, HttpServletRequest request) {
    	
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	StandardError err = new StandardError(
    			System.currentTimeMillis(), 
    			status.value(), 
    			"Product não inserido.", 
    			e.getMessage(), 
    			request.getRequestURI());
    	
    	return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ProductExistsException.class)
    public ResponseEntity<StandardError> productExistsException(ProductExistsException e, HttpServletRequest request) {
    	
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	StandardError err = new StandardError(
    			System.currentTimeMillis(), 
    			status.value(), 
    			"Produto ja existente.", 
    			e.getMessage(), 
    			request.getRequestURI());
    	
    	return ResponseEntity.status(status).body(err);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ErrorObject> errors) {
        return new ErrorResponse("Requisição possui campos inválidos", status.value(),
                status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }
}

