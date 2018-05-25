package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.RoomType;

public interface RoomTypeService {
	public List<RoomType> select();//查询所有房间类型
	public int add(RoomType roomType);//添加房间类型
	public int updateBatch(List<RoomType> roomTypes);//批量更新
	public int update(RoomType roomType);//更新房间类型
	public int delete(Integer roomTypeId);//删除房间类型
}
