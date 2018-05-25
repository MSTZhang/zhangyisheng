package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.Order;
import com.zhangyisheng.entity.OrderPage;

public interface OrderService {
	public List<Order> select();//��ѯ���ж���
	public Order findById(String orderId);//���ݶ���id��ѯ
	public List<Order> findByTel(String tel);//���ݵ绰��ѯ
	public Order findByRoomId(Integer roomId);//���ݷ���id����
	public String add(Order order);//���Ԥ����Ϣ
	public List<Order> selecUnCheck();//�����û�id����δ��ס�Ķ���
	public List<Order> selectHisCheck();//�����û�id��ѯ��ʷ����
	public String customBook(Order order);//�ͻ��¶���
	public int operatorBook(Order order);//�Ƶ����ԱԤ��
	public int updateIsApply(Order order);//���¶�����֧��״̬
	public int cancelOrder(String orderId);//ȡ������
	public OrderPage selectByPage(Integer page);
}
