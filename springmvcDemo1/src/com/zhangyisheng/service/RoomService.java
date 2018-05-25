package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.dao.RoomDao;
import com.zhangyisheng.entity.Room;

public interface RoomService {
	public List<Room> select();//��ѯ���з���
	public Room findById(Integer roomId);//���ݷ���Ų�ѯ
	public List<Room> findRtp(Integer roomTypeId);//���ݷ������Ͳ�ѯ
	public int delete(Integer roomId);//ɾ��
	public int update(Room room);//���·�����Ϣ
	public int alertStatus(Room room);//�޸ķ���״̬
	public int add(Room room);//��ӷ���
	public List<Room> selectByRyAc(Room room);//���ݷ������ͺͻid����
}
