package com.example.comm.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseNogariEntityExceptionHandler  extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(value = {NogariExcaption.class})
    public ResponseEntity<?> handleUserNotFound(NogariExcaption nogariExcaption, WebRequest request){
        return super.handleExceptionInternal(
        		nogariExcaption,
        		nogariExcaption.getMessage(),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request
        );
    }
}
