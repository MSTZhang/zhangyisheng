package com.zhangyisheng.service;

import java.util.List;

import com.zhangyisheng.entity.User;

public interface UserService {
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
