package com.java.springJpaTest.service;

import java.util.List;
import com.java.springJpaTest.dto.UserRequest;
import com.java.springJpaTest.entity.User;

public interface UserService {
	
	/**
	 * Create user.
	 * @param User user
	 * @return User
	 */
	User createUser(User user);
	/**
	 * Get user by given id.
	 * @param Long user id
	 * @return User
	 */
    User getUserById(Long userId);
    /**
	 * Returns all Users.
	 * @return List<User>
	 */
    List<User> getAllUsers();

    User updateUser(Long id, UserRequest userRequest);

    void deleteUser(Long userId);

}
