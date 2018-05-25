package com.zhangyisheng.authorization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.zhangyisheng.utlity.CodecUtil;
import com.zhangyisheng.utlity.Constants;
import com.zhangyisheng.utlity.StringUtil;
import com.zhangyisheng.utlity.WebContextUtil;
@Component
public class DefaultTokenManager implements TokenManager{
	private static Map<String, Object> tokenMap = new ConcurrentHashMap<String, Object>();
	@Override
	public String createToken(Object obj) {
		String token = CodecUtil.createUUID();
		HttpServletResponse resp = WebContextUtil.getResponse();
		System.out.println(token);
		Cookie cookie = new Cookie(Constants.DEFAULT_TOKEN_NAME,token);
		cookie.setPath("/springmvcDemo1/");
		resp.addCookie(cookie);
		tokenMap.put(token, obj);
		return token;
	}

	@Override
	public boolean checkToken(String token) {
		// TODO Auto-generated method stub
		return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);
	}

	@Override
	public void deleteToken(String token) {
		// TODO Auto-generated method stub
		tokenMap.remove(token);
	}

	@Override
	public Object getToken(String token) {
		// TODO Auto-generated method stub
		return tokenMap.get(token);
	}

}
