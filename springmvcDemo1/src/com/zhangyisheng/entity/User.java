package com.zhangyisheng.entity;
/**
 * ��̨������Ա�˺�ʵ��
 * @author zhangyisheng
 *
 */
public class User {
	private Integer id;//�˺�id
	private String userName;//Ա������
	private String account;//��¼�˺�
	private String password;//��¼����
	private String email;//����
	private Integer level;//�˺ż���   1.����Ա   2.��ͨ�˺�
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public User(){}
	public User(Integer id, String userName, String account, String password,
			String email, Integer level) {
		this.id = id;
		this.userName = userName;
		this.account = account;
		this.password = password;
		this.email = email;
		this.level = level;
	}
	
}
