package com.java.springJpaTest.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class ResourceNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8177970133666652902L;
	private String message; 
    public ResourceNotFoundException(String message) {
		this.message = message;
	}

}
