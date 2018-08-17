package com.example.valentino.qa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

public class RedisConfig {
	
	
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
		return jedisPoolConfig;
	}
	
	
	
	
	public JedisConnectionFactory jedisConnectionFactory(){
		
		
		JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("192.168.201.55");
		jedisConnectionFactory.setPassword("p@ss$12E45");
		System.out.println("redisConnectionFactory ------------------------------------------DEFAULT-----------------------------------");
		return jedisConnectionFactory;
	}
	
	
	public StringRedisTemplate stringRedisTemplate()
	{
		return new StringRedisTemplate(jedisConnectionFactory());
	}

}
