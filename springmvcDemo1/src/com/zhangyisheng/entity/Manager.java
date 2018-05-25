package com.zhangyisheng.entity;

public class Manager {
	private Integer id;
	private String userCount;
	private String pwd;
	private Integer mLevel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCount() {
		return userCount;
	}
	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public Integer getmLevel() {
		return mLevel;
	}
	public void setmLevel(Integer mLevel) {
		this.mLevel = mLevel;
	}
	public Manager() {
	}
	public Manager(Integer id, String userCount, String pwd, Integer mLevel) {
		this.id = id;
		this.userCount = userCount;
		this.pwd = pwd;
		this.mLevel = mLevel;
	}
	
}
