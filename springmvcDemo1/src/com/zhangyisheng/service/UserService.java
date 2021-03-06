package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.User;

public interface UserService {
	//根据账号和密码查询
	public User findByAccountPassword(User user);
	//查询所有
	public List<User> selectAll();
	//添加
	public int addUser(User user);
	//更新
	public int updateUser(User user);
	//删除
	public int deleteUser(User user);
}
