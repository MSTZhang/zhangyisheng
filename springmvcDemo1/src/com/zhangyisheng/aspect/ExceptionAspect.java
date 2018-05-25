package com.zhangyisheng.aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zhangyisheng.exception.TokenException;
import com.zhangyisheng.response.Response;
/**
 * Title: 全局异常处理切面 Description: 利用 @ControllerAdvice + @ExceptionHandler
 * 组合处理Controller层RuntimeException异常
 * 
 * @author rico
 * @created 2017年7月4日 下午4:29:07
 */
@ControllerAdvice   // 鎺у埗鍣ㄥ寮�
@ResponseBody
public class ExceptionAspect {

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Response handleHttpMessageNotReadableException(
			HttpMessageNotReadableException e) {
		return new Response().failure("could_not_read_json");
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public Response handleValidationException(MethodArgumentNotValidException e) {
		
		return new Response().failure("parameter_validation_exception");
	}

	/**
	 * 405 - Method Not Allowed銆侶ttpRequestMethodNotSupportedException
	 * 鏄疭ervletException鐨勫瓙绫�闇�Servlet API鏀寔
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Response handleHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException e) {
		return new Response().failure("request_method_not_supported");
	}

	/**
	 * 415 - Unsupported Media Type銆侶ttpMediaTypeNotSupportedException
	 * 鏄疭ervletException鐨勫瓙绫�闇�Servlet API鏀寔
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler({ HttpMediaTypeNotSupportedException.class })
	public Response handleHttpMediaTypeNotSupportedException(Exception e) {
		return new Response().failure("content_type_not_supported");
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(TokenException.class)
	public Response handleTokenException(Exception e) {
		return new Response().failure("Token is invaild");
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Response handleException(Exception e) {
		System.out.println("发生异常:"+e);
		return new Response().failure("Internal Server Error");
	}
}
