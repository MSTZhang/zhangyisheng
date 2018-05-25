package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Room;
@MapperScan
public interface RoomDao {
	public List<Room> select();//查询所有房间
	public Room findById(Integer roomId);//根据房间号查询
	public List<Room> findRtp(Room room);//根据房间类型查询
	public int delete(Room room);//删除
	public int update(Room room);//更新房间信息
	public int alertStatus(Room room);//修改房价状态
	public int add(Room room);//添加房间
	public List<Room> selectByRyAc(Room room);//根据房间类型和活动id查找
}
