package com.ljj.redis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ljj.redis.bean.User;
import com.ljj.redis.service.UserService;

public class Main {

	/**
	 * @param args����Redis
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml"        );  
        UserService userService =  (UserService) applicationContext.getBean("userService");  
              
        User user1 = new User("user1ID", "User 1");  
        User user2 = new User("user2ID", "User 2");  
          
       System.out.println("==== getting objects from redis ====");  
       System.out.println("User is not in redis yet: " + userService.get(user1));  
       System.out.println("User is not in redis yet: " + userService.get(user2));  
          
        System.out.println("==== putting objects into redis ====");  
        userService.put(user1);  
        userService.put(user2);  
          
        System.out.println("==== getting objects from redis ====");  
        System.out.println("User should be in redis yet: " + userService.get(user1));  
        System.out.println("User should be in redis yet: " + userService.get(user2));  
          
        System.out.println("==== deleting objects from redis ====");  
        userService.delete(user1);  
        userService.delete(user2);  
          
        System.out.println("==== getting objects from redis ====");  
        System.out.println("User is not in redis yet: " + userService.get(user1));  
        System.out.println("User is not in redis yet: " + userService.get(user2));  
	}

}
