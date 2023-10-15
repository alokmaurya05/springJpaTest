package com.java.springJpaTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private long id;
	private String firstName;
	private String lastName ;
	private String email ;
}
