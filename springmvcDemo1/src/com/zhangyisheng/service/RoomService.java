package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.dao.RoomDao;
import com.zhangyisheng.entity.Room;

public interface RoomService {
	public List<Room> select();//查询所有房间
	public Room findById(Integer roomId);//根据房间号查询
	public List<Room> findRtp(Integer roomTypeId);//根据房间类型查询
	public int delete(Integer roomId);//删除
	public int update(Room room);//更新房间信息
	public int alertStatus(Room room);//修改房价状态
	public int add(Room room);//添加房间
	public List<Room> selectByRyAc(Room room);//根据房间类型和活动id查找
}
