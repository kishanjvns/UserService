package com.tech.kj.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tech.kj.entity.User;

public interface UserService {
	 public List<User> getAllUsers();
	 public User getUserById(@PathVariable Long id);
	 public User createUser(@RequestBody User user);
	 public User updateUser(@PathVariable Long id, @RequestBody User user);
	 public void deleteUser(@PathVariable Long id);
	 public User assignRoleToUser(@PathVariable Long userId, @PathVariable Long roleId);

}
