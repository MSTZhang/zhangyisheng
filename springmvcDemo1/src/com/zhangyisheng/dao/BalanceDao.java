package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Balance;
@MapperScan
public interface BalanceDao {
	public List<Balance> select();
	public int add(Balance balance);//添加入住单号
	public int update(Balance balance);//更新
	public int delete(String balanceNumber);
	public Balance findByCheckNum(String checkNum);
}
