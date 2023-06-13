package com.tech.kj.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

@Configuration
class AppConfig {
	@Value("${spring.redis.host}")
	private String redisHost;
	@Value("${spring.redis.port}")
	private int redisPort;
	
	@Bean
	public Jedis jedi() {
		Jedis jedis = new Jedis(new HostAndPort(redisHost, redisPort));
		return jedis;
	}

}