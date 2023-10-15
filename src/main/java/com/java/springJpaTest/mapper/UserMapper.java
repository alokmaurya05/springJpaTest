package com.java.springJpaTest.mapper;





import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.java.springJpaTest.dto.UserRequest;
import com.java.springJpaTest.dto.UserResponse;
import com.java.springJpaTest.entity.User;

public  class UserMapper {
	
	public static User createUser(UserRequest userReq) {
		User user = new User() ;
		user.setFirstName(userReq.getFirstName());
		user.setLastName(userReq.getLastName());
		user.setEmail(userReq.getEmail());
		return user ;
	}
	public static UserResponse getUser(User user) {
		UserResponse userResponse = new UserResponse() ;
		userResponse.setId(user.getId());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setEmail(user.getEmail());
		return userResponse ;
	}
	
	public static List<UserResponse> getUsers(List<User> users){
		List<UserResponse> userList = new ArrayList<UserResponse>();	
		for(User user:users) {
			UserResponse userResponse = new UserResponse() ;
			userResponse.setId(user.getId());
			userResponse.setFirstName(user.getFirstName());
			userResponse.setLastName(user.getLastName());
			userResponse.setEmail(user.getEmail());
			userList.add(userResponse);
		}
		return userList;
	}
	public static User getToUpdate(User existingUser, UserRequest userToUpdate) {

		if (StringUtils.hasText(userToUpdate.getFirstName())) {
			existingUser.setFirstName(userToUpdate.getFirstName());
		}
		if (StringUtils.hasText(userToUpdate.getLastName())) {
			existingUser.setLastName(userToUpdate.getLastName());
		}
		if (StringUtils.hasText(userToUpdate.getEmail())) {
			existingUser.setEmail(userToUpdate.getEmail());
		}
		return existingUser;
	}

}
