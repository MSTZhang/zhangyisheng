package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Manager;
@MapperScan
public interface ManagerDao {
	public Manager findByNum(Manager manager);//根据账号和密码查找
	public List<Manager> select();//查询所有的酒店操作员信息
	public int add(Manager manager);//添加管理员账号
	public int delete(String account);//根据账号删除
	public int update(Manager manager);//更新账号信息
	public int alertPwd(Manager manager);//修改密码
}
