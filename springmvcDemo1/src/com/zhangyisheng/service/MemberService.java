package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.Member;

public interface MemberService {
	public List<Member> select();//��ѯȫ����Ա��Ϣ
	public Member findByTelOrEmail(Member member);//���ݵ绰���������
	public boolean add(Member member);//����û�
	public boolean update(Member member);//�����û�
	public boolean updatePwd(String currentPwd,String newPwd);//�޸�����
	public boolean delete(Member member);//ɾ��
	public Member findByTel(String tel);
}
