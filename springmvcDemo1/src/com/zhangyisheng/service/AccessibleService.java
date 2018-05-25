package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.AccessEx;
import com.zhangyisheng.entity.AccessGoodRate;
import com.zhangyisheng.entity.Accessible;

public interface AccessibleService {
	public List<Accessible> select();//��ѯȫ���û�����
	public int add(Accessible accessible);//���
	public int update(Accessible accessbile);//����������Ϣ
	public int delete(Integer accNumber);//��������idɾ��
	public List<AccessEx> findByUId(Integer accStatus);//���ݻ�Աid��ѯ
	public AccessGoodRate findGoodRate();//��ѯ�Ƶ�����ʼ���������
}
