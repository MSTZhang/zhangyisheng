package com.zhangyisheng.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangyisheng.authorization.TokenManager;
import com.zhangyisheng.dao.MemberDao;
import com.zhangyisheng.entity.Member;
import com.zhangyisheng.exception.TokenException;
import com.zhangyisheng.service.MemberService;
import com.zhangyisheng.utlity.Constants;
import com.zhangyisheng.utlity.DisCountConstans;
import com.zhangyisheng.utlity.WebContextUtil;
@Service
public class MemberServiceImpl implements MemberService{
	@Resource
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Resource
	private TokenManager tokenManager;
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
	@Override
	public Member findByTelOrEmail(Member member) {
		Member mb = memberDao.findByTelOrEmail(member);
		if(mb==null){
			throw new TokenException("用户名或密码错误");
		}
		String token="";
		if(member.getEmail()==null){
			System.out.println("创建cookie");
			token = tokenManager.createToken(mb);
		}else if(member.getTel()==null){
			token = tokenManager.createToken(mb);
		}
		return mb;
	}

	@Override
	public boolean add(Member member) {
		// TODO Auto-generated method stub
		member.setCmLevel(1);
		member.setIsAble(1);
		member.setDiscount(DisCountConstans.level0);
		int i =memberDao.add(member);
		if(i<0){
			throw new TokenException("添加失败");
		}
		return true;
	}

	@Override
	public boolean update(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePwd(String currentPwd,String newPwd) {
		// TODO Auto-generated method stub
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		Member mb =(Member) tokenManager.getToken(token);
		if(mb.getPwd().equals(currentPwd)){
			Member me = new Member();
			me.setTel(mb.getTel());
			me.setPwd(newPwd);
			memberDao.updatePwd(me);
			tokenManager.deleteToken(token);
		}else{
			throw new TokenException("密码不正确");
		}
		return false;
	}

	@Override
	public boolean delete(Member member) {
		// TODO Auto-generated method stub
		int i =memberDao.deleteMember(member);
		if(i<0){
			throw new TokenException("删除失败");
		}
		return true;
	}
	@Override
	public List<Member> select() {
		// TODO Auto-generated method stub
		return memberDao.select();
	}
	@Override
	public Member findByTel(String tel) {
		// TODO Auto-generated method stub
		return memberDao.findByTel(tel);
	}

}
