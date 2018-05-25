package com.zhangyisheng.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyisheng.entity.Order;
import com.zhangyisheng.entity.OrderPage;
import com.zhangyisheng.response.Response;
import com.zhangyisheng.service.OrderService;
@Controller
public class OrderAction {
	@Resource
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//���ݷ���id����
	@RequestMapping(value="/order/findByRmId",method=RequestMethod.GET)
	@ResponseBody
	public Response findByRmId(Integer roomId){
		Order order = orderService.findByRoomId(roomId);
		Response res = new Response();
		System.out.println(roomId);
		System.out.println(order);
		return res.success(order);
	}
	//���Ԥ����Ϣ�Ƶ������Ա
	//���ݷ���id����
	@RequestMapping(value="/order/operatorAdd",method=RequestMethod.POST)
	@ResponseBody
	public Response add(@RequestBody Order order){
		orderService.add(order);
		Response response = new Response();
		return response.success();
	}
	//��ѯ��ʷ����
	@RequestMapping(value="/order/findHisCheck",method=RequestMethod.GET)
	@ResponseBody
	public Response findHisCheck(){
		List<Order> orders = orderService.selectHisCheck();
		Response res = new Response();
		return res.success(orders);
	}
	//��ѯ��ʷ����
	@RequestMapping(value="/order/findUnCheck",method=RequestMethod.GET)
	@ResponseBody
	public Response findUnCheck(){
		List<Order> orders = orderService.selecUnCheck();
		Response res = new Response();
		return res.success(orders);
	}
	//�ͻ����Ԥ����Ϣ
	@RequestMapping(value="/order/customAdd",method=RequestMethod.POST)
	@ResponseBody
	public Response customAdd(@RequestBody Order order){
		String orderId = orderService.customBook(order);
		Response res = new Response();
		return res.success(orderId);
	}
	//���ݶ����Ų���
	@RequestMapping(value="/order/findByOrderNum",method=RequestMethod.GET)
	@ResponseBody
	public Response findByOrderNum(String orderId){
		Response res = new Response();
		Order order = orderService.findById(orderId);
		return res.success(order);
	}
	//���¶���֧��״̬
	@RequestMapping(value="/order/updateIsApply",method=RequestMethod.POST)
	@ResponseBody
	public Response updateIsApply(@RequestBody Order order){
		Response res = new Response();
		return res.success();
	}
	//����ȡ��
	@RequestMapping(value="/order/cancelOrder",method=RequestMethod.GET)
	@ResponseBody
	public Response cancelOrder(String orderId){
		Response res = new Response();
		orderService.cancelOrder(orderId);
		return res.success();
	}
	//��ҳ��ѯ
	@RequestMapping(value="/order/selectByPage",method=RequestMethod.GET)
	@ResponseBody
	public Response selectByPage(Integer page){
		Response res= new Response();
		OrderPage orderPage = orderService.selectByPage(page);
		return res.success(orderPage);
	}
}
