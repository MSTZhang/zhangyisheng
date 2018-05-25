package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Order;
import com.zhangyisheng.entity.OrderEx;
@MapperScan
public interface OrderDao {
	public List<Order> select();//查询所有订单
	public Order findById(String orderId);//根据订单id查询
	public List<Order> findByTel(String tel);//根据电话查询
	public List<Order> findByRoomId(Integer roomId);//根据房间id查找
	public Order findByRmIdCh(Order order);
	public int updateStatus(Order order);//更新订单状态
	public int add(Order order);//添加预定信息
	public List<Order> selecUnCheck(String tel);//根据用户id查找未入住的订单
	public List<Order> selectHisCheck(String tel);//根据用户id查询历史订单
	public List<OrderEx> isBook(Order order);
	public int updateIsApply(Order order);//更新订单的支付状态 
	public List<Order> selectByPage(Integer page);//分页查询
	public int count();//查询总记录数
}
