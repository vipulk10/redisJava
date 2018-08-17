package com.example.valentino.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;


public class QaApplication {

	
	
	public static void main(String[] args) {
		
			JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
			jedisPoolConfig.setMaxIdle(30);
			jedisPoolConfig.setMinIdle(10);
			
			JedisShardInfo j = new JedisShardInfo("192.168.201.84", 6379);
			j.setPassword("p@ss$12E45");
			
			JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory(jedisPoolConfig);
			jedisConnectionFactory.setHostName("192.168.201.84");
			jedisConnectionFactory.setPassword("p@ss$12E45");
			jedisConnectionFactory.setPort(6379);
			jedisConnectionFactory.setTimeout(5000);
			jedisConnectionFactory.setShardInfo(j);
			
			System.out.println("redisConnectionFactory ------------------------------------------DEFAULT-----------------------------------");
			
			StringRedisTemplate st = new StringRedisTemplate(jedisConnectionFactory);
			
			System.out.println(st.opsForValue().get("shrey"));
		
		
		SpringApplication.run(QaApplication.class, args);
		
		
	}
}
