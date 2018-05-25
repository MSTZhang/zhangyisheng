package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.RoomType;
@MapperScan
public interface RoomTypeDao {
	public List<RoomType> select();//��ѯ���з�������
	public int add(RoomType roomType);//��ӷ�������
	//public int updateBatch(RoomType roomType);//��������
	public int update(RoomType roomType);//���·�������
	public int delete(Integer roomTypeId) ;//ɾ����������
}
