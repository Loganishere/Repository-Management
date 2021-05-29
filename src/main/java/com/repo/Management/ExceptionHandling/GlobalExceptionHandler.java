package com.repo.Management.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.repo.Management.Model.GenericErrorModel;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({RequiredFieldsEmptyException.class})
	public ResponseEntity<GenericErrorModel> requiredFieldsEmptyException(RequiredFieldsEmptyException emptyException) {
		return new ResponseEntity<>(new GenericErrorModel("400", "Bad Request", "Required fields are empty"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<GenericErrorModel> categoryNotFoundException(CategoryNotFoundException categoryNotFound) {
		return new ResponseEntity<>(new GenericErrorModel("404", "Not Found", "Category could not be found"), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<GenericErrorModel> productNotFoundException(ProductNotFoundException productNotFound) {
		return new ResponseEntity<>(new GenericErrorModel("404", "Not Found", "Product could not be found"), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<GenericErrorModel> HttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadable) {
		return new ResponseEntity<>(new GenericErrorModel("400", "Bad Request", "Input JSON is Null or Invalid"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyJsonException.class)
	public ResponseEntity<GenericErrorModel> EmptyJsonException(EmptyJsonException emptyJsonException) {
		return new ResponseEntity<>(new GenericErrorModel("400", "Bad Request", "Input JSON is Null or Invalid"), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<GenericErrorModel> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupported) {
		return new ResponseEntity<>(new GenericErrorModel("400", "Bad Request", "HTTP Method Invalid"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<GenericErrorModel> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException argumentTypeMismatchException) {
		return new ResponseEntity<>(new GenericErrorModel("400", "Bad Request", "Invalid Input Data Type"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BuyQuantityInvalidException.class)
	public ResponseEntity<GenericErrorModel> BuyQuantityInvalidException(BuyQuantityInvalidException buyQuantityInvalidException) {
		return new ResponseEntity<>(new GenericErrorModel("400", "Bad Request", "Product Buy Quantity greater than Available Quantity"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericErrorModel> genericException(Exception e) {
		return new ResponseEntity<>(new GenericErrorModel(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
