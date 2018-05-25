package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Order;
import com.zhangyisheng.entity.OrderEx;
@MapperScan
public interface OrderDao {
	public List<Order> select();//��ѯ���ж���
	public Order findById(String orderId);//���ݶ���id��ѯ
	public List<Order> findByTel(String tel);//���ݵ绰��ѯ
	public List<Order> findByRoomId(Integer roomId);//���ݷ���id����
	public Order findByRmIdCh(Order order);
	public int updateStatus(Order order);//���¶���״̬
	public int add(Order order);//���Ԥ����Ϣ
	public List<Order> selecUnCheck(String tel);//�����û�id����δ��ס�Ķ���
	public List<Order> selectHisCheck(String tel);//�����û�id��ѯ��ʷ����
	public List<OrderEx> isBook(Order order);
	public int updateIsApply(Order order);//���¶�����֧��״̬ 
	public List<Order> selectByPage(Integer page);//��ҳ��ѯ
	public int count();//��ѯ�ܼ�¼��
}
