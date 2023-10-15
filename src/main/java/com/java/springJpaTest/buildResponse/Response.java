package com.java.springJpaTest.buildResponse;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.java.springJpaTest.dto.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	 private static final String SUCCESS = "SUCCESS";
	    private static final String FAIL = "FAIL";
	    private String status = SUCCESS;
	    private String message = null;
	    private Object data = null;
	    
	    private Response(String status, String message)
	    {
	        this.status = status;
	        this.message = message ;
	    }

		public static ResponseEntity<?> success(Object data ,HttpStatus status)
	    {
	        return new ResponseEntity<Object>(data,status);
	    }
	    
	    public static ResponseEntity<UserResponse> success(UserResponse user ,HttpStatus status)
	    {
	        return new ResponseEntity<UserResponse>(user,status);
	    }
	    public static ResponseEntity<List<UserResponse>> success(List<UserResponse> users ,HttpStatus status)
	    {
	        return new ResponseEntity<List<UserResponse>>(users,status);
	    }
	    
	    public static Response success(String message)
	    {
	        return new Response(SUCCESS, message);
	    }
	    public static ResponseEntity<String> success(String message, HttpStatus status)
	    {
	        return new ResponseEntity<String>(message, status);
	    }
	    public static Response success(String message, Object data)
	    {
	        return new Response(SUCCESS, message, data);
	    }
	    
	    public static Response fail(String message, Object data)
	    {
	        return new Response(FAIL, message, data);
	    }
}
