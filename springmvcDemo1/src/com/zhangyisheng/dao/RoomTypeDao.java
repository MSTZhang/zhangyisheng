package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.RoomType;
@MapperScan
public interface RoomTypeDao {
	public List<RoomType> select();//查询所有房间类型
	public int add(RoomType roomType);//添加房间类型
	//public int updateBatch(RoomType roomType);//批量更新
	public int update(RoomType roomType);//更新房间类型
	public int delete(Integer roomTypeId) ;//删除房间类型
}
