package com.zhangyisheng.aspect;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Controller;

import com.zhangyisheng.annotation.IgnoreSecurity;
import com.zhangyisheng.authorization.TokenManager;
import com.zhangyisheng.exception.TokenException;
import com.zhangyisheng.utlity.Constants;
import com.zhangyisheng.utlity.WebContextUtil;

@Controller
@Aspect
public class SecurityAspect {
	@Resource
	private TokenManager tokenManager;
	
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public Object execute(ProceedingJoinPoint pjp) throws Throwable{
		//System.out.println("���󵽴�");
		// ���е��ϻ�ȡĿ�귽��
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		// ��Ŀ�귽�������˰�ȫ�Լ��,��ֱ�ӵ���Ŀ�귽��
		if (method.isAnnotationPresent(IgnoreSecurity.class)) {
			return pjp.proceed();
		}

		// �� request header �л�ȡ��ǰ token
		//WebContextUtil.printCookie();
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		// ��� token ��Ч��
		System.out.println("X-Token:"+token);
		if (!tokenManager.checkToken(token)) {
			String message = String.format("token [%s] is invalid", token);
			throw new TokenException(message);
		}
		// ����Ŀ�귽��
		return pjp.proceed();
	}
}
