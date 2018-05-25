package com.zhangyisheng.entity;
/**
 * 后台管理人员账号实体
 * @author zhangyisheng
 *
 */
public class User {
	private Integer id;//账号id
	private String userName;//员工姓名
	private String account;//登录账号
	private String password;//登录密码
	private String email;//邮箱
	private Integer level;//账号级别   1.管理员   2.普通账号
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
