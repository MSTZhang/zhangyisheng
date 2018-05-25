package com.zhangyisheng.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangyisheng.authorization.TokenManager;
import com.zhangyisheng.dao.OrderDao;
import com.zhangyisheng.entity.Member;
import com.zhangyisheng.entity.Order;
import com.zhangyisheng.entity.OrderEx;
import com.zhangyisheng.entity.OrderPage;
import com.zhangyisheng.entity.Room;
import com.zhangyisheng.exception.TokenException;
import com.zhangyisheng.service.MemberService;
import com.zhangyisheng.service.OrderService;
import com.zhangyisheng.service.RoomService;
import com.zhangyisheng.utlity.CodecUtil;
import com.zhangyisheng.utlity.Constants;
import com.zhangyisheng.utlity.WebContextUtil;
@Service
public class orderServiceImpl implements OrderService{
	@Resource
	private OrderDao orderDao;
	@Resource
	private RoomService roomService;
	@Resource
	private TokenManager tokenManager;
	@Resource
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findById(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.findById(orderId);
	}

	@Override
	public List<Order> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findByRoomId(Integer roomId) {
		// TODO Auto-generated method stub
		return orderDao.findByRoomId(roomId).get(0);
	}
	@Transactional
	@Override
	public String add(Order order) {
		//添加预定信息
		Date date= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String str = format.format(date);
		order.setBookTime(str);
		//生成orderId
		String orderId = CodecUtil.createNumber();
		order.setOdStatus(1);
		order.setOrderId(orderId);
		order.setIsApply(1);
		int q = orderDao.add(order);
		//修改房间状态
		Room room = new Room();
		room.setRoomId(order.getRmId());
		room.setRmStatus(2);
		int x = roomService.alertStatus(room);
		if(q<0||x<0){
			throw new TokenException("添加失败");
		}
		
		return orderId;
	}
	
	@Override
	public List<Order> selecUnCheck() {
		// TODO Auto-generated method stub
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		Member mb =(Member) tokenManager.getToken(token);
		return orderDao.selecUnCheck(mb.getTel());
	}

	@Override
	public List<Order> selectHisCheck() {
		// TODO Auto-generated method stub
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		Member mb =(Member) tokenManager.getToken(token);
		return orderDao.selectHisCheck(mb.getTel());
	}
	@Transactional
	@Override
	public String customBook(Order order) {
		//查询房间号
		Room rm = order.getRoom();
		rm.setRoomTypeId(order.getRtyId());
		List<Room> list = roomService.selectByRyAc(rm);
		//遍历房间列表，查看是否与已有预定信息或入住信息冲突
		boolean flag =false;
		for(Room rm1:list){
			order.setRmId(rm1.getRoomId());
			List<OrderEx> ods = orderDao.isBook(order);
			if(ods==null||ods.size()==0){
				flag = true;
				break;
			}
		}
		String orderId = null;
		if(flag){
			//计算订单价格
			String tel = order.getCustomTel();
			//查询会员折扣
			Member member = memberService.findByTel(tel);
			double discount = member.getDiscount();
			//查询房间价格
			int roomId=order.getRmId();
			Room room = roomService.findById(roomId);
			Double price = 0.0;
			if(room.getFlexible()!=null){
				price = room.getFlexible().getAcPrice();
			}else{
				price = room.getRoomType().getPrice();
			}
			double totalPrice = CodecUtil.totalMoney(order.getCheckTime(), order.getLeaveTime(), price, discount);
			order.setTotalPrice(totalPrice);
			orderId = add(order);
		}else if(!false){
			throw new TokenException("预定失败，没有空闲客房");
		}
		return orderId;
	}
	@Override
	public int operatorBook(Order order) {
		List<OrderEx> list = orderDao.isBook(order);
		if(list==null||list.size()==0){
			add(order);
		}
		return 0;
	}
	@Override
	public int updateIsApply(Order order) {
		// TODO Auto-generated method stub
		return orderDao.updateIsApply(order);
	}
	@Override
	public int cancelOrder(String orderId) {
		// TODO Auto-generated method stub
	    Order order=new Order();
	    order.setOrderId(orderId);
	    order.setOdStatus(3);
		return orderDao.updateStatus(order);
	}
	@Override
	public OrderPage selectByPage(Integer page) {
		// TODO Auto-generated method stub
		List<Order> orders = orderDao.selectByPage((page-1)*20);
		int count = orderDao.count();
		int pages=0;
		if(count%20==0){
			pages = count/20;
		}else{
			pages = count/20+1;
		}
		OrderPage orderPage = new OrderPage();
		orderPage.setCurrentPage(page);
		orderPage.setOrders(orders);
		orderPage.setTotalCount(count);
		orderPage.setTotalPage(pages);
		return orderPage;
	}
	
}
