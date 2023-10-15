package com.java.springJpaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.springJpaTest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
