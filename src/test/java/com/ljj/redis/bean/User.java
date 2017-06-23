package com.ljj.redis.bean;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String OBJECT_KEY = "USER";  
	     private String id;  
	    private String userName;  
	public User(){
		//¹¹ÔìÆ÷
	}
	public User(String id){
		
	}
	 public User(String id, String userName) {  
	        this.id = id;  
	        this.userName = userName;  
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}  
	public String toString(){
		
		 return "User [id=" + id + ", userName=" + userName + "]";  
		
	} 
	
	  public String getKey() {  
	        return getId();  
	    }  
	  
	    public String getObjectKey() {  
	        return OBJECT_KEY;  
	    }  
}
