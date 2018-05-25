package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.Balance;
@MapperScan
public interface BalanceDao {
	public List<Balance> select();
	public int add(Balance balance);//�����ס����
	public int update(Balance balance);//����
	public int delete(String balanceNumber);
	public Balance findByCheckNum(String checkNum);
}
