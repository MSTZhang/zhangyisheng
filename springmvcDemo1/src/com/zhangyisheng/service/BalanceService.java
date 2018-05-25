package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.Balance;

public interface BalanceService {
	public List<Balance> select();
	public int add(Balance balance);//�����ס����
	public int update(Balance balance);//����
	public int delete(String balanceNumber);
	public int balance(String checkNum);//����
	public Balance findByCheckNum(String checkNum);
}
