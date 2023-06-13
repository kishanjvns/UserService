package com.tech.kj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisService {

    private final Jedis jedis;

    @Autowired
    public RedisService(Jedis jedis) {
        this.jedis = jedis;
    }

    public void setKey(String key, String value) {
        jedis.set(key, value);
    }

    public String getValue(String key) {
        return jedis.get(key);
    }
}
