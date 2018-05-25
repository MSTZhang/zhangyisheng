package com.zhangyisheng.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.zhangyisheng.entity.User;
@MapperScan
public interface UserDao {
	//�����˺ź������ѯ
	public User findByAccountPassword(User user);
	//��ѯ����
	public List<User> selectAll();
	//���
	public int addUser(User user);
	//����
	public int updateUser(User user);
	//ɾ��
	public int deleteUser(User user);
}
