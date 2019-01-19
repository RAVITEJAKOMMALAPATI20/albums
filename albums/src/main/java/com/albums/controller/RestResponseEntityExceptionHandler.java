package com.albums.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.albums.exception.AlbumAPIValidationException;



/**
 * @author pragathiReddy
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	
	public RestResponseEntityExceptionHandler() {
        super();
    }
	
    @ExceptionHandler({ AlbumAPIValidationException.class })
    public ResponseEntity<Object> handleBadRequest(final AlbumAPIValidationException ex, final WebRequest request) {
    	
        final String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
   
}
