package com.zhangyisheng.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyisheng.response.Response;
import com.zhangyisheng.service.BalanceService;
@Controller
public class BalanceAction {
	@Resource
	private BalanceService balanceService;

	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}
	
	//����
	@RequestMapping(value="/balance/checkOut",method=RequestMethod.GET)
	@ResponseBody
	public Response checkOut(String checkNum){
		System.out.println("���ڽ���,����:"+checkNum);
		Response res = new Response();
		balanceService.balance(checkNum);
		return res.success();
	}
}
