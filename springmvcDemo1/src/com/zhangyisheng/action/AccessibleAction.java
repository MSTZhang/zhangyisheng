package com.zhangyisheng.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyisheng.annotation.IgnoreSecurity;
import com.zhangyisheng.entity.AccessEx;
import com.zhangyisheng.entity.AccessGoodRate;
import com.zhangyisheng.entity.Accessible;
import com.zhangyisheng.response.Response;
import com.zhangyisheng.service.AccessibleService;

@Controller
public class AccessibleAction {
	@Resource
	private AccessibleService accessibleService;

	public void setAccessibleService(AccessibleService accessibleService) {
		this.accessibleService = accessibleService;
	}
	//��ѯ���ݻ�Աid
	@RequestMapping(value="/accessible/findByUId",method=RequestMethod.GET)
	@ResponseBody
	public Response findByUId(Integer status){
		System.out.println("���ڲ�ѯ");
		List<AccessEx> list = accessibleService.findByUId(status);
		System.out.println(list);
		Response res= new Response();
		return res.success(list);
	}
	//��������
	@RequestMapping(value="/accessible/update",method=RequestMethod.POST)
	@ResponseBody
	public Response updateAcc(@RequestBody Accessible accessible){
		accessibleService.update(accessible);
		Response res = new Response();
		return res.success();
	}
	//��ѯ�����ʼ���������
	@RequestMapping(value="/accessible/findGoodRate",method=RequestMethod.GET)
	@ResponseBody
	@IgnoreSecurity
	public Response findContentList(){
		Response res = new Response();
		AccessGoodRate list = accessibleService.findGoodRate();
		return res.success(list);
	}
}
