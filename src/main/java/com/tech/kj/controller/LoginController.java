package com.tech.kj.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.f4b6a3.uuid.UuidCreator;
import com.tech.kj.dto.ApiResponseDto;
import com.tech.kj.dto.LoginRequestDto;
import com.tech.kj.service.LoginService;
import com.tech.kj.service.RedisService;
import com.tech.kj.service.UserServiceConstant;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	

	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponseDto> login(@RequestBody LoginRequestDto requestDto){
		String validationResult = loginService.validateUserNameAndPassword(requestDto.getUserName(), requestDto.getPassword());
		ApiResponseDto apiResponseDto = new ApiResponseDto();
		if(!StringUtils.isEmpty(validationResult)) {
			
			Map<String, String> objecData = new HashMap<String, String>();
			objecData.put("token", validationResult);
			apiResponseDto.setData(objecData);
			apiResponseDto.setStatusCode(UserServiceConstant.CODE_SUCCESS);
			apiResponseDto.setMessage("Success");
			
		}else {
			apiResponseDto.setStatusCode(UserServiceConstant.CODE_INVALID_VALUE);
			apiResponseDto.setMessage(UserServiceConstant.ERROR_MSG_INVALID_CREDENTIAL);
		}
		return ResponseEntity.ok(apiResponseDto);
	}
	
}
