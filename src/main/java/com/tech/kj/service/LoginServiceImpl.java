package com.tech.kj.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.f4b6a3.uuid.UuidCreator;
import com.tech.kj.entity.User;
import com.tech.kj.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RedisService redisService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public String validateUserNameAndPassword(String userName, String password) {
		User user = userRepository.findByEmail(userName);
		if(user != null && user.getPassword().equals(password)){
			UUID uuid = UuidCreator.getTimeOrderedEpoch();
			try {
				redisService.setKey(uuid.toString(), objectMapper.writeValueAsString(user));
			} catch (JsonProcessingException e) {
				throw new IllegalArgumentException(e.getCause().getMessage());
				//e.printStackTrace();
			}
			return uuid.toString();
		}
		return "";
	}

}
