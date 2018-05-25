package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Room;
@MapperScan
public interface RoomDao {
	public List<Room> select();//��ѯ���з���
	public Room findById(Integer roomId);//���ݷ���Ų�ѯ
	public List<Room> findRtp(Room room);//���ݷ������Ͳ�ѯ
	public int delete(Room room);//ɾ��
	public int update(Room room);//���·�����Ϣ
	public int alertStatus(Room room);//�޸ķ���״̬
	public int add(Room room);//��ӷ���
	public List<Room> selectByRyAc(Room room);//���ݷ������ͺͻid����
}
