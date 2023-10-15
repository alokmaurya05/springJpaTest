package com.java.springJpaTest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserRequest {
    
	
	private String firstName;
	private String lastName ;
	private String email ;
}
