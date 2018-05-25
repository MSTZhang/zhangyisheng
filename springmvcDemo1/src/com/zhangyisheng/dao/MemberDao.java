package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Member;
@MapperScan
public interface MemberDao {
	public List<Member> select();//查询全部
	public Member findById(Integer userId);
	public Member findByTelOrEmail(Member member);//根据电话和密码或者是emial和密码查询用户
	public int updatePwd(Member member);//更新密码
	public int updateMember(Member member);//更新用户所有资料
	public int deleteMember(Member member);//删除用户
	public int add(Member member);//添加用户
	public Member findByTel(String tel);//根据电话查找
}
