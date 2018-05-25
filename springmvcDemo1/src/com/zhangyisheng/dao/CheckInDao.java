package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.CheckIn;
@MapperScan
public interface CheckInDao {
	public List<CheckIn> select();//查询所有的入住信息
	public CheckIn findByRmId(Integer roomId);//根据房间id查找
	public CheckIn findByCId(String checkNum);//根据入住id查找
	public int update(CheckIn checkIn);//更新订单
	public int delete(String checkNum);//删除
	public int add(CheckIn checkIn);//添加入住信息
	public int updateStatus(CheckIn checkIn);//更新入住信息状态
}
