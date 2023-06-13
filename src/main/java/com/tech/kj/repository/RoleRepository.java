package com.tech.kj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.kj.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}

