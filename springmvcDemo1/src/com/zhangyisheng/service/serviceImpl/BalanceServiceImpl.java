package com.zhangyisheng.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangyisheng.dao.BalanceDao;
import com.zhangyisheng.entity.Balance;
import com.zhangyisheng.entity.CheckIn;
import com.zhangyisheng.entity.Room;
import com.zhangyisheng.service.BalanceService;
import com.zhangyisheng.service.CheckInService;
import com.zhangyisheng.service.RoomService;
@Service
public class BalanceServiceImpl implements BalanceService{
	@Resource
	private BalanceDao balanceDao;
	@Resource
	private CheckInService checkService;
	@Resource
	private RoomService roomService;
	public void setBalanceDao(BalanceDao balanceDao) {
		this.balanceDao = balanceDao;
	}

	public void setCheckService(CheckInService checkService) {
		this.checkService = checkService;
	}

	@Override
	public List<Balance> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Balance balance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Balance balance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String balanceNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional
	@Override
	public int balance(String checkNum) {
		// TODO Auto-generated method stub
		CheckIn checkIn = checkService.findByCId(checkNum);
		Double price = checkService.totalPrice(checkNum);
		//设置结束信息
		Balance balance = new Balance();
		balance.setBalanceNumber(checkIn.getBalanceNumber());
		balance.setCheckNumber(checkNum);
		balance.setPrice(price);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String str = format.format(date);
		int days=(int) (((date.getTime())-checkIn.getCheckTime().getTime())/((24*60*60*1000)));
		balance.setRealDays(days);
		balance.setBalanceTime(str);
		//更新结算信息
		balanceDao.update(balance);
		//更新入住表信息
		checkIn.setStatus(2);;
		checkService.updateStatus(checkIn);
		//更改房间状态为脏房
		Room room = new Room();
		room.setRoomId(checkIn.getRmId());
		room.setRmStatus(4);
		roomService.alertStatus(room);
		return 0;
	}

	@Override
	public Balance findByCheckNum(String checkNum) {
		// TODO Auto-generated method stub
		return balanceDao.findByCheckNum(checkNum);
	}

}
