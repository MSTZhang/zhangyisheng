package com.zhangyisheng.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyisheng.annotation.IgnoreSecurity;
import com.zhangyisheng.authorization.TokenManager;
import com.zhangyisheng.entity.Member;
import com.zhangyisheng.response.Response;
import com.zhangyisheng.service.MemberService;
import com.zhangyisheng.utlity.Constants;
import com.zhangyisheng.utlity.WebContextUtil;
@Controller
public class MemberAction {
	@Resource
	MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@Resource
	private TokenManager tokenManager;
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
	//��¼��֤
	@RequestMapping(value = "/member", method = RequestMethod.POST, produces = "application/json", 
            consumes = "application/json")
	@IgnoreSecurity
	@ResponseBody
	public Response loginValidate(@RequestBody Member member){
		//System.out.println("���󵽴�"+member.getCustomName().charAt(0)+"  "+member.getPwd());
		System.out.println("��ʼ��¼");
		Member mb = memberService.findByTelOrEmail(member);
		System.out.println("��¼�ɹ�");
		Response res = new Response();
		return res.success(mb);
	}
	//��ȡ��¼��Ϣ
	@RequestMapping(value="/loginInfo",method = RequestMethod.GET)
	@ResponseBody
	public Response getUserInfo()  {
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		Member mb =(Member) tokenManager.getToken(token);
		Response res = new Response();
		return res.success(mb);
	}
	//��ȡ��¼��Ϣ
	@IgnoreSecurity
	@RequestMapping(value="/member/register",method = RequestMethod.POST)
	@ResponseBody
	public Response addMember(@RequestBody Member member){
		System.out.println("����û�");
		memberService.add(member);
		Response res = new Response();
		return res.success();
	}
	//��ѯȫ����Ա��Ϣ
	@IgnoreSecurity
	@RequestMapping(value="/member/select",method = RequestMethod.POST)
	@ResponseBody
	public Response selectAll(){
		System.out.println("��ѯȫ���û�");
		List<Member> list = memberService.select();
		Response res = new Response();
		return res.success(list);
	}
	//���»�Ա��Ϣ
	@IgnoreSecurity
	@RequestMapping(value="/member/update",method = RequestMethod.POST)
	@ResponseBody
	public Response update(){
		System.out.println("��ѯȫ���û�");
		List<Member> list = memberService.select();
		Response res = new Response();
		return res.success(list);
	}
	//ɾ���û�
	@IgnoreSecurity
	@RequestMapping(value="/member/delete",method = RequestMethod.POST)
	@ResponseBody
	public Response deleteMember(@RequestBody Member member){
		System.out.println("ɾ���û�");
		memberService.delete(member);
		Response res = new Response();
		return res.success();
	}
	//��������
	@RequestMapping(value="/member/updatePwd",method = RequestMethod.GET)
	@ResponseBody
	public Response updatePwd(String newPwd,String currentPwd){
		Response res = new Response();
		return res.success();
	}
	//�˳���¼
	@RequestMapping(value="/member/exitLogin",method = RequestMethod.GET)
	@ResponseBody
	public Response exitLogin(){
		Response res = new Response();
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		tokenManager.deleteToken(token);
		return res.success();
	}
}
