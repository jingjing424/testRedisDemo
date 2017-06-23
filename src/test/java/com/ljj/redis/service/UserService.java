package com.ljj.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ljj.redis.bean.User;
@Service("userService")  
public class UserService {
	 @Autowired  
	RedisTemplate<String, User> redisTemplate;
	//��redis�в�������
	public void put(User user){
		
		redisTemplate.opsForHash().put(user.getObjectKey(), user.getKey(), user);
		
	}
	
	//��redis��ɾ������
	public void delete(User user){
		
		redisTemplate.opsForHash().delete(user.getObjectKey(), user.getKey(), user);
		
	}
	//��redis�л�ȡ����
	public User get(User user){
		
		return (User) redisTemplate.opsForHash().get(user.getObjectKey(), user.getKey());
		
	}

	public RedisTemplate<String, User> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	
	
	
}
