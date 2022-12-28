package com.te.blogmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.blogmanagement.entity.User;

@Repository
public interface UserRegistrationRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
