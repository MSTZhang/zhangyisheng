package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.CheckIn;

public interface CheckInService {
	public List<CheckIn> select();//��ѯ���е���ס��Ϣ
	public CheckIn findByRmId(Integer roomId);//���ݷ���id����
	public CheckIn findByCId(String checkNum);//������סid����
	public int update(CheckIn checkIn);//���¶���
	public int delete(String checkNum);//ɾ��
	public int add(CheckIn checkIn);//�����ס��Ϣ
	public Double totalPrice(String checkNum);//�����ܼ۸�
	public int updateStatus(CheckIn checkIn);
	public int balance(String checkNum);//����
}
