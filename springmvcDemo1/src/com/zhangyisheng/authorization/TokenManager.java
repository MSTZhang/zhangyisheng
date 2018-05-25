package com.zhangyisheng.authorization;

public interface TokenManager {
	String createToken(Object obj);  

    boolean checkToken(String token); 

    void deleteToken(String token); 
    Object getToken(String token);
}
