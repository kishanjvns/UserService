package com.tech.kj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.kj.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

