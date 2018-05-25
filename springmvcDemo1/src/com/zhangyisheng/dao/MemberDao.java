package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Member;
@MapperScan
public interface MemberDao {
	public List<Member> select();//��ѯȫ��
	public Member findById(Integer userId);
	public Member findByTelOrEmail(Member member);//���ݵ绰�����������emial�������ѯ�û�
	public int updatePwd(Member member);//��������
	public int updateMember(Member member);//�����û���������
	public int deleteMember(Member member);//ɾ���û�
	public int add(Member member);//����û�
	public Member findByTel(String tel);//���ݵ绰����
}
