package com.zhangyisheng.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangyisheng.dao.RoomDao;
import com.zhangyisheng.entity.Room;
import com.zhangyisheng.exception.TokenException;
import com.zhangyisheng.service.RoomService;
@Service
public class RoomServiceImpl implements RoomService{
	@Resource
	private RoomDao roomDao;
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	@Override
	public List<Room> select() {
		// TODO Auto-generated method stub
		return roomDao.select();
	}
	@Override
	public Room findById(Integer roomId) {
		// TODO Auto-generated method stub
		return roomDao.findById(roomId);
	}
	@Override
	public List<Room> findRtp(Integer roomTypeId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Integer roomId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(Room room) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int add(Room room) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int alertStatus(Room room) {
		// TODO Auto-generated method stub
		int i = roomDao.alertStatus(room);
		if(i<0){
			throw new TokenException("ÐÞ¸ÄÊ§°Ü");
		}
		return i;
	}
	@Override
	public List<Room> selectByRyAc(Room room) {
		// TODO Auto-generated method stub
		return roomDao.selectByRyAc(room);
	}
	

}
