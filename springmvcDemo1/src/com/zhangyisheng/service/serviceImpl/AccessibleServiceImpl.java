package com.zhangyisheng.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangyisheng.authorization.TokenManager;
import com.zhangyisheng.dao.AccessibleDao;
import com.zhangyisheng.entity.AccessEx;
import com.zhangyisheng.entity.AccessExclu;
import com.zhangyisheng.entity.AccessGoodRate;
import com.zhangyisheng.entity.Accessible;
import com.zhangyisheng.entity.Balance;
import com.zhangyisheng.entity.CheckIn;
import com.zhangyisheng.entity.Member;
import com.zhangyisheng.exception.TokenException;
import com.zhangyisheng.service.AccessibleService;
import com.zhangyisheng.service.BalanceService;
import com.zhangyisheng.service.CheckInService;
import com.zhangyisheng.utlity.Constants;
import com.zhangyisheng.utlity.WebContextUtil;
@Service
public class AccessibleServiceImpl implements AccessibleService{
	@Resource
	private AccessibleDao accessibleDao;
	@Resource
	private TokenManager tokenManager;
	@Resource
	private BalanceService balanceService;
	@Resource
	private CheckInService checkInService;
	public void setAccessibleDao(AccessibleDao accessibleDao) {
		this.accessibleDao = accessibleDao;
	}

	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
	
	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}
	
	public void setCheckInService(CheckInService checkInService) {
		this.checkInService = checkInService;
	}

	@Override
	public List<Accessible> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Accessible accessible) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Accessible accessbile) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		String str = format.format(date);
		accessbile.setAccTime(str);
		int q = accessibleDao.update(accessbile);
		if(q<0){
			throw new TokenException("更新失败");
		}
		return q;
	}

	@Override
	public int delete(Integer accNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AccessEx> findByUId(Integer accStatus) {
		// TODO Auto-generated method stub
		//获取会员信息
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		Member mb =(Member) tokenManager.getToken(token);
		//查询评价信息
		Accessible acc = new Accessible();
		acc.setCustomId(mb.getId());
		acc.setStatus(accStatus);
		List<Accessible> list = accessibleDao.findByUId(acc);
		//组装评价信息的扩展类
		List<AccessEx> list1=null;
		if(list!=null&&list.size()>0){
			list1=new ArrayList<AccessEx>();
			for(Accessible ac:list ){
				//计算总房价
				//Double totalPrice=0;
				//查询入住单号
				CheckIn checkIn = checkInService.findByCId(ac.getCheckNum());
				//查询结算单号
				Balance bl = balanceService.findByCheckNum(ac.getCheckNum());
				AccessEx ae = new AccessEx();
				Date date = checkIn.getCheckTime();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				String str = format.format(date);
				str=str+"/"+bl.getBalanceTime();
				ae.setAccNumber(ac.getAccNumber());
				ae.setStatus(ac.getStatus());
				ae.setHotelName("阳光酒店管理系统");
				ae.setDate(str);
				ae.setTotalPrice(bl.getPrice());
				list1.add(ae);
			}
		}
		return list1;
	}

	@Override
	public AccessGoodRate findGoodRate() {
		// TODO Auto-generated method stub
		AccessGoodRate ag= accessibleDao.findGoodRate();
		List<AccessExclu> list = accessibleDao.selectAccEd();
		ag.setAccessExclua(list);
		return ag;
	}

}
