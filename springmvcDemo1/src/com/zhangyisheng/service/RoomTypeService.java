package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.RoomType;

public interface RoomTypeService {
	public List<RoomType> select();//��ѯ���з�������
	public int add(RoomType roomType);//��ӷ�������
	public int updateBatch(List<RoomType> roomTypes);//��������
	public int update(RoomType roomType);//���·�������
	public int delete(Integer roomTypeId);//ɾ����������
}
