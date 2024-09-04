package com.bholacodecamp.repository;

import com.bholacodecamp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
