package com.zhangyisheng.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangyisheng.dao.AccessibleDao;
import com.zhangyisheng.dao.BalanceDao;
import com.zhangyisheng.dao.CheckInDao;
import com.zhangyisheng.dao.MemberDao;
import com.zhangyisheng.dao.OrderDao;
import com.zhangyisheng.dao.RoomDao;
import com.zhangyisheng.entity.Accessible;
import com.zhangyisheng.entity.Balance;
import com.zhangyisheng.entity.CheckIn;
import com.zhangyisheng.entity.Flexible;
import com.zhangyisheng.entity.Member;
import com.zhangyisheng.entity.Order;
import com.zhangyisheng.entity.Room;
import com.zhangyisheng.exception.TokenException;
import com.zhangyisheng.service.CheckInService;
import com.zhangyisheng.service.RoomService;
import com.zhangyisheng.utlity.CodecUtil;
@Service
public class CheckInServiceImpl implements CheckInService{
	@Resource
	private CheckInDao checkInDao;
	@Resource
	private RoomDao roomDao;
	@Resource
	private OrderDao orderDao;
	@Resource
	private MemberDao memberDao;
	@Resource
	private AccessibleDao accessibleDao;
	@Resource
	private BalanceDao balanceDao;
	public void setCheckInDao(CheckInDao checkInDao) {
		this.checkInDao = checkInDao;
	}
	
	public void setAccessibleDao(AccessibleDao accessibleDao) {
		this.accessibleDao = accessibleDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void setMember(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setBalanceDao(BalanceDao balanceDao) {
		this.balanceDao = balanceDao;
	}

	@Override
	public List<CheckIn> select() {
		// TODO Auto-generated method stub
		return checkInDao.select();
	}

	@Override
	public CheckIn findByRmId(Integer roomId) {
		// TODO Auto-generated method stub
		return checkInDao.findByRmId(roomId);
	}

	@Override
	public CheckIn findByCId(String checkNum) {
		// TODO Auto-generated method stub
		return checkInDao.findByCId(checkNum);
	}

	@Override
	public int update(CheckIn checkIn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String checkNum) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional
	@Override
	public int add(CheckIn checkIn) {
		// TODO Auto-generated method stub
		String chNm = CodecUtil.createNumber();
		String blNm = CodecUtil.createNumber();
		checkIn.setBalanceNumber(blNm);
		checkIn.setCheckNumber(chNm);
		checkIn.setStatus(1);
		/**
		 * 
		 */
		//根据房间id查找预定信息
		Order order1 = new Order();
		order1.setCheckTime(checkIn.getCheckTime());
		order1.setLeaveTime(checkIn.getLeaveTime());
		order1.setRmId(checkIn.getRmId());
		order1.setOdStatus(1);
		Order order = orderDao.findByRmIdCh(order1);
		order.setOdStatus(2);
		Member mb=null;
		if(order!=null){
			mb = memberDao.findByTel(order.getCustomTel());
			orderDao.updateStatus(order);
		}
		/**
		 * 
		 */
		if(mb!=null){
			checkIn.setUserId(mb.getId());
		}
		/**
		 * 
		 */
		int i = checkInDao.add(checkIn);
		Room room =new Room();
		room.setRmStatus(3);
		room.setRoomId(checkIn.getRmId());
		int a =roomDao.alertStatus(room);
		if(i<0){
			throw new TokenException("添加失败");
		}
		//添加结算单号
		Balance bl = new Balance();
		bl.setCheckNumber(chNm);
		bl.setBalanceNumber(blNm);
		balanceDao.add(bl);
		return i;
	}

	@Override
	public Double totalPrice(String checkNum) {
		// TODO Auto-generated method stub
		//查询入住信息
		CheckIn cif = checkInDao.findByCId(checkNum);
		//查询房间信息
		Room room = roomDao.findById(cif.getRmId());
		//获取会员信息
		Integer userId = cif.getUserId();
		Double discount = 1.0;
		if(userId!=null){
			Member mb = memberDao.findById(userId);
			discount = mb.getDiscount();
		}
		
		int days=(int) Math.ceil( (((double)((new Date().getTime())-cif.getCheckTime().getTime()))/((24*60*60*1000))));
		System.out.println(new Date().getTime()+"    "+cif.getCheckTime().getTime());
		Flexible fb = room.getFlexible();
		Double price=room.getRoomType().getPrice();
		if(fb!=null){
			price = room.getFlexible().getAcPrice();
		}
		Double totalPrice =  price*days*discount;
		System.out.println(totalPrice);
		return  totalPrice;
	}

	@Override
	public int updateStatus(CheckIn checkIn) {
		// TODO Auto-generated method stub
		return checkInDao.updateStatus(checkIn);
	}
	@Transactional
	@Override
	public int balance(String checkNum) {
		CheckIn checkIn = findByCId(checkNum);
		Double price = totalPrice(checkNum);
		//设置结束信息
		Balance balance = new Balance();
		balance.setBalanceNumber(checkIn.getBalanceNumber());
		balance.setCheckNumber(checkNum);
		balance.setPrice(price);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String str = format.format(date);
		int days=(int) Math.ceil( (((date.getTime())-checkIn.getCheckTime().getTime())/((24*60*60*1000))));
		balance.setRealDays(days);
		balance.setBalanceTime(str);
		//更新结算信息
		balanceDao.update(balance);
		//更新入住表信息
		checkIn.setStatus(2);;
		updateStatus(checkIn);
		//更改房间状态为脏房
		Room room = new Room();
		room.setRoomId(checkIn.getRmId());
		room.setRmStatus(4);
		roomDao.alertStatus(room);
		//查询订单
		Order order1 = new Order();
		order1.setCheckTime(checkIn.getCheckTime());
		order1.setLeaveTime(checkIn.getLeaveTime());
		order1.setRmId(checkIn.getRmId());
		order1.setOdStatus(2);
		Order order = orderDao.findByRmIdCh(order1);
		//order.setOdStatus(2);
		Member mb=null;
		if(order!=null){
			mb = memberDao.findByTel(order.getCustomTel());
		}
		//添加评论
		if(order!=null&&mb!=null){
			Accessible acc = new Accessible();
			acc.setCustomId(mb.getId());
			acc.setOrderId(order.getOrderId());
			acc.setCheckNum(checkIn.getCheckNumber());
			acc.setStatus(1);
			accessibleDao.add(acc);
		}
		return 0;
	}
	
}
