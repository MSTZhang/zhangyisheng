package com.zhangyisheng.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangyisheng.authorization.TokenManager;
import com.zhangyisheng.dao.ManagerDao;
import com.zhangyisheng.entity.Manager;
import com.zhangyisheng.exception.TokenException;
import com.zhangyisheng.service.ManagerService;
import com.zhangyisheng.utlity.Constants;
import com.zhangyisheng.utlity.WebContextUtil;
@Service
public class ManagerServiceImpl implements ManagerService{
	@Resource
	private ManagerDao managerDao;
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	@Resource
	private TokenManager tokenManager;
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
	@Override
	public Manager findByNum(Manager manager) {
		Manager mg = managerDao.findByNum(manager);
		if(mg==null){
			throw new TokenException("√‹¬ÎªÚ’À∫≈¥ÌŒÛ");
		}
		tokenManager.createToken(mg);
		return mg;
	}

	@Override
	public List<Manager> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Manager manager) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Manager manager) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alertPwd(String oldPwd,String newPwd) {
		String token = WebContextUtil.getToken(Constants.DEFAULT_TOKEN_NAME);
		Manager mg = (Manager) tokenManager.getToken(token);
		int q=-1;
		if(mg.getPwd().equals(oldPwd)){
			Manager mg1 = new Manager();
			mg1.setUserCount(mg.getUserCount());
			mg1.setPwd(newPwd);
			q = managerDao.alertPwd(mg1);
			if(q<0){
				throw new TokenException("–ﬁ∏ƒ√‹¬Î ß∞‹");
			}
			tokenManager.deleteToken(token);
		}else{
			throw new TokenException("æ…√‹¬Î¥ÌŒÛ£°£°£°");
		}
		return q;
	}

}
