package com.zhangyisheng.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyisheng.annotation.IgnoreSecurity;
import com.zhangyisheng.authorization.TokenManager;
import com.zhangyisheng.entity.Manager;
import com.zhangyisheng.response.Response;
import com.zhangyisheng.service.ManagerService;
import com.zhangyisheng.utlity.Constants;
import com.zhangyisheng.utlity.WebContextUtil;
@Controller
public class ManagerAction {
	@Resource
	private ManagerService managerService;
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	@Resource
	private TokenManager tokenManager;
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
	//管理员登录验证
	@RequestMapping(value = "/manager/login", method = RequestMethod.POST, produces = "application/json", 
            consumes = "application/json")
	@IgnoreSecurity
	@ResponseBody
	public Response login(@RequestBody Manager manager){
		//System.out.println("开始登录");
		Manager mg = managerService.findByNum(manager);
		Response res = new Response();
		return res.success(mg);
	}
	//获取登录信息
	@RequestMapping(value = "/manager/loginValidate", method = RequestMethod.GET, produces = "application/json", 
            consumes = "application/json")
	@ResponseBody
	public Response validateLogin(){
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		Manager mg = (Manager) tokenManager.getToken(token);
		return new Response().success(mg);
	}
	//修改密码
	@RequestMapping(value = "/manager/alterPwd", method = RequestMethod.GET, produces = "application/json", 
            consumes = "application/json")
	@ResponseBody
	public Response alertPwd(String oldPwd,String newPwd){
		Response response =new Response();
		managerService.alertPwd(oldPwd, newPwd);
		return response.success();
	}
}
