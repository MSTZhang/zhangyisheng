package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Manager;
@MapperScan
public interface ManagerDao {
	public Manager findByNum(Manager manager);//�����˺ź��������
	public List<Manager> select();//��ѯ���еľƵ����Ա��Ϣ
	public int add(Manager manager);//��ӹ���Ա�˺�
	public int delete(String account);//�����˺�ɾ��
	public int update(Manager manager);//�����˺���Ϣ
	public int alertPwd(Manager manager);//�޸�����
}
