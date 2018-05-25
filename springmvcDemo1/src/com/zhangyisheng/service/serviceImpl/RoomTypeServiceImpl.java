package com.zhangyisheng.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangyisheng.authorization.TokenManager;
import com.zhangyisheng.dao.RoomTypeDao;
import com.zhangyisheng.entity.Manager;
import com.zhangyisheng.entity.RoomType;
import com.zhangyisheng.exception.TokenException;
import com.zhangyisheng.service.RoomTypeService;
import com.zhangyisheng.utlity.Constants;
import com.zhangyisheng.utlity.WebContextUtil;
@Service("roomTypeService")
public class RoomTypeServiceImpl implements RoomTypeService{
	@Resource
	private RoomTypeDao roomTypeDao;
	public void setRoomTypeDao(RoomTypeDao roomTypeDao) {
		this.roomTypeDao = roomTypeDao;
	}
	@Resource
	private TokenManager tokenManager;
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
	@Override
	public List<RoomType> select() {
		// TODO Auto-generated method stub
		List<RoomType> roomList = roomTypeDao.select();
		//ͳ�ƿ��з�����
		/*if(roomList!=null&&roomList.size()>0){
			
		}*/
		return roomList;
	}

	@Override
	public int add(RoomType roomType) {
		// TODO Auto-generated method stub
		//�ж��ǲ��ǹ���Ա
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		Object obj = tokenManager.getToken(token);
		if(obj instanceof Manager){
			Manager mg = (Manager) obj;
			if(mg.getmLevel()<2){
				throw new TokenException("���ʧ��,��ǰ�˺ŷǹ���Ա");
			}
		}else{
			throw new TokenException("���ʧ��,��ǰ�˺ŷǹ���Ա");
		}
		return roomTypeDao.add(roomType);
	}

	@Override
	public int update(RoomType roomType) {
		// TODO Auto-generated method stub
		int q = roomTypeDao.add(roomType);
		if(q<0){
			throw new TokenException("���ʧ��");
		}
		return roomTypeDao.update(roomType);
	}

	@Override
	public int delete(Integer roomTypeId) {
		// TODO Auto-generated method stub
		//�ж��ǲ��ǹ���Ա
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		Object obj = tokenManager.getToken(token);
		if(obj instanceof Manager){
			Manager mg = (Manager) obj;
			if(mg.getmLevel()<2){
				throw new TokenException("���ʧ��,��ǰ�˺ŷǹ���Ա");
			}
		}else{
			throw new TokenException("���ʧ��,��ǰ�˺ŷǹ���Ա");
		}
		int q=0;
		q=roomTypeDao.delete(roomTypeId);
		if(q<0){
			throw new TokenException("ɾ��ʧ�ܣ��Ƿ�ɾ��");
		}
		return q;
	}

	@Override
	public int updateBatch(List<RoomType> roomTypes) {
		// TODO Auto-generated method stub
		int q = 0;
		int nm=0;
		if(roomTypes!=null&&roomTypes.size()>0){
			for(int i=0;i<roomTypes.size();i++){
				q = roomTypeDao.update(roomTypes.get(i));
				if(q<0){
					throw new TokenException("����ʧ��");
				}
			}
		}
		return q;
	}

}
