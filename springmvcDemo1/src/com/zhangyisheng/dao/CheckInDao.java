package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.CheckIn;
@MapperScan
public interface CheckInDao {
	public List<CheckIn> select();//��ѯ���е���ס��Ϣ
	public CheckIn findByRmId(Integer roomId);//���ݷ���id����
	public CheckIn findByCId(String checkNum);//������סid����
	public int update(CheckIn checkIn);//���¶���
	public int delete(String checkNum);//ɾ��
	public int add(CheckIn checkIn);//�����ס��Ϣ
	public int updateStatus(CheckIn checkIn);//������ס��Ϣ״̬
}
