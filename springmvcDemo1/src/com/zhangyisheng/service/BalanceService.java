package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.Balance;

public interface BalanceService {
	public List<Balance> select();
	public int add(Balance balance);//添加入住单号
	public int update(Balance balance);//更新
	public int delete(String balanceNumber);
	public int balance(String checkNum);//结算
	public Balance findByCheckNum(String checkNum);
}
