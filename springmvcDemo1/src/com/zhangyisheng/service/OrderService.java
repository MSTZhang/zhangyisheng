package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.Order;
import com.zhangyisheng.entity.OrderPage;

public interface OrderService {
	public List<Order> select();//查询所有订单
	public Order findById(String orderId);//根据订单id查询
	public List<Order> findByTel(String tel);//根据电话查询
	public Order findByRoomId(Integer roomId);//根据房间id查找
	public String add(Order order);//添加预定信息
	public List<Order> selecUnCheck();//根据用户id查找未入住的订单
	public List<Order> selectHisCheck();//根据用户id查询历史订单
	public String customBook(Order order);//客户下订单
	public int operatorBook(Order order);//酒店管理员预定
	public int updateIsApply(Order order);//更新订单的支付状态
	public int cancelOrder(String orderId);//取消订单
	public OrderPage selectByPage(Integer page);
}
