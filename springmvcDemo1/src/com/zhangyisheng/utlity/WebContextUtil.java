package com.zhangyisheng.utlity;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
/**        
 * Title: Web涓婁笅鏂囧伐鍏风被
 * @author rico       
 * @created 2017骞�鏈�鏃�涓嬪崍5:16:42    
 */      
public class WebContextUtil {
	  
	/**     
	 * @description 鑾峰彇HTTP璇锋眰    
	 * @author rico       
	 * @created 2017骞�鏈�鏃�涓嬪崍5:18:08     
	 * @return     
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}
	public static void printCookie(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies){
			System.out.println(cookie.getName()+"   "+cookie.getValue());
		}
	}
	public static String getToken(String tokenName){
		String token ="";
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies){
			if(tokenName.equals(cookie.getName())){
				token = cookie.getValue();
				break;
			}
		}
		return token;
	}
	public static HttpServletResponse getResponse(){
		HttpServletResponse resp =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		return resp;
	}
}
