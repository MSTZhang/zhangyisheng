package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.AccessEx;
import com.zhangyisheng.entity.AccessGoodRate;
import com.zhangyisheng.entity.Accessible;

public interface AccessibleService {
	public List<Accessible> select();//查询全部用户评价
	public int add(Accessible accessible);//添加
	public int update(Accessible accessbile);//更新评价信息
	public int delete(Integer accNumber);//根据评价id删除
	public List<AccessEx> findByUId(Integer accStatus);//根据会员id查询
	public AccessGoodRate findGoodRate();//查询酒店好评率及评论内容
}
