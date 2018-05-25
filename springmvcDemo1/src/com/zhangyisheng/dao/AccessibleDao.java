package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.AccessExclu;
import com.zhangyisheng.entity.AccessGoodRate;
import com.zhangyisheng.entity.Accessible;
import com.zhangyisheng.entity.Order;
@MapperScan
public interface AccessibleDao {
	public List<Accessible> select();//查询全部用户评价
	public int add(Accessible accessible);//添加
	public int update(Accessible accessbile);//更新评价信息
	public int delete(Integer accNumber);//根据评价id删除
	public List<Accessible> findByUId(Accessible accessible);//根据会员id查询
	public List<AccessExclu> selectAccEd();///查询已完成的评价
	public AccessGoodRate findGoodRate();//查询好评率
}
