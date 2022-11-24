package com.fitbody.api.exception;

import java.util.NoSuchElementException;

import org.hibernate.PropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(PropertyValueException.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<String>("Error, todos os campos devem ser preenchidos!", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> integrityViolationException(Exception e){
		return new ResponseEntity<String>("Error, não é possivel inserir dados desta forma!", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> NotReadableException(Exception e){
		return new ResponseEntity<String>("Error, não foi possível encontrar o elemento", HttpStatus.BAD_REQUEST);
	}
}
