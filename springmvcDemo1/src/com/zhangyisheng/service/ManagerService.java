package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.Manager;

public interface ManagerService {
	public Manager findByNum(Manager manager);//�����˺ź��������
	public List<Manager> select();//��ѯ���еľƵ����Ա��Ϣ
	public int add(Manager manager);//��ӹ���Ա�˺�
	public int delete(String account);//�����˺�ɾ��
	public int update(Manager manager);//�����˺���Ϣ
	public int alertPwd(String oldPwd,String newPwd);//�޸�����
}
