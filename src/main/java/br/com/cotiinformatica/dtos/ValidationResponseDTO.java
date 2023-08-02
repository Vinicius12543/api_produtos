package br.com.cotiinformatica.dtos;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ValidationResponseDTO {
 
	private HttpStatus status;
	private String message;
	private List<ValidationErrorResponseDTO> errors;
	
	
	
	
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ValidationErrorResponseDTO> getErrors() {
		return errors;
	}
	public void setErrors(List<ValidationErrorResponseDTO> errors) {
		this.errors = errors;
	}
	
	
	
	
	
}
