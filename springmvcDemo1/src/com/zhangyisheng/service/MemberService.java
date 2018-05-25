package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.Member;

public interface MemberService {
	public List<Member> select();//查询全部会员信息
	public Member findByTelOrEmail(Member member);//根据电话或邮箱查找
	public boolean add(Member member);//添加用户
	public boolean update(Member member);//更新用户
	public boolean updatePwd(String currentPwd,String newPwd);//修改密码
	public boolean delete(Member member);//删除
	public Member findByTel(String tel);
}
