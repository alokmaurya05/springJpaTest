package com.java.springJpaTest.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springJpaTest.buildResponse.Response;
import com.java.springJpaTest.dto.UserRequest;
import com.java.springJpaTest.dto.UserResponse;
import com.java.springJpaTest.entity.User;
import com.java.springJpaTest.mapper.UserMapper;
import com.java.springJpaTest.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	Logger log =LogManager.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<UserResponse> userSave(@RequestBody UserRequest userRequest) throws Exception {

		log.info("User request start with parameters {}", userRequest);
		User userData = null;
		try {
			userData = userService.createUser(UserMapper.createUser(userRequest));
		} catch (Exception e) {
			log.error("Error in save User ", e.getMessage());
			throw new Exception(e.getMessage());
		}
		log.info("Save User details {} ", userData);
		UserResponse userResponse = UserMapper.getUser(userData);
		return Response.success(userResponse, HttpStatus.CREATED);
	}
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<UserResponse> getByUserId(@PathVariable(name = "id") Long id){
		
		log.info("Get user by id {}",id);
		User user =userService.getUserById(id);
		log.info("Get User details {} ", user);
        UserResponse userResponse = UserMapper.getUser(user);
		return Response.success(userResponse, HttpStatus.OK);
		
	}
	@PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateProductFields(@PathVariable Long id,@RequestBody UserRequest userRequest){
        log.info("Patch request to update user by id {} and userRequest {}",id,userRequest);
		User user = userService.updateUser(id, userRequest);
        UserResponse userResponse = UserMapper.getUser(user);
      return Response.success(userResponse, HttpStatus.OK);
        		
    }
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<UserResponse>> getAllUser() {
		log.info("Get all users");
		List<User> users = userService.getAllUsers();
		List<UserResponse> userResponse = UserMapper.getUsers(users);

		return Response.success(userResponse, HttpStatus.OK);

	}

}
