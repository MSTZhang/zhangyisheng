package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.AccessExclu;
import com.zhangyisheng.entity.AccessGoodRate;
import com.zhangyisheng.entity.Accessible;
import com.zhangyisheng.entity.Order;
@MapperScan
public interface AccessibleDao {
	public List<Accessible> select();//��ѯȫ���û�����
	public int add(Accessible accessible);//���
	public int update(Accessible accessbile);//����������Ϣ
	public int delete(Integer accNumber);//��������idɾ��
	public List<Accessible> findByUId(Accessible accessible);//���ݻ�Աid��ѯ
	public List<AccessExclu> selectAccEd();///��ѯ����ɵ�����
	public AccessGoodRate findGoodRate();//��ѯ������
}
