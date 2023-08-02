package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class ValidationErrorResponseDTO {
	
	private String name;
	private String error;
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public ValidationErrorResponseDTO(String name, String error) {
		super();
		this.name = name;
		this.error = error;
	}
	
	public ValidationErrorResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
