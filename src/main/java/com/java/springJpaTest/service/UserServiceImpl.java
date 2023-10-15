package com.java.springJpaTest.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springJpaTest.dto.UserRequest;
import com.java.springJpaTest.entity.User;
import com.java.springJpaTest.exception.ResourceNotFoundException;
import com.java.springJpaTest.mapper.UserMapper;
import com.java.springJpaTest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	Logger log = LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		throw new ResourceNotFoundException("User not found");
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users =userRepository.findAll();
		if(!users.isEmpty()){
		return users ;
		}
	 throw new ResourceNotFoundException("No user data avaliable");
	}

	@Override
	public User updateUser(Long id, UserRequest userRequest) {
		User existingUser = getUserById(id);
		log.info("Before user update {}",existingUser);
		User userToUpdate = UserMapper.getToUpdate(existingUser, userRequest);
		User updatedUser = userRepository.save(userToUpdate);
		log.info("After user update {}",updatedUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);

	}

}
