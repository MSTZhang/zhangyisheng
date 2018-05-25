package com.zhangyisheng.entity;

public class Member {
	private Integer id;
	private String customName;//房客姓名
	private String pwd;//登录密码
	private String tel;//联系电话
	private String email;//邮箱
	private Integer cmLevel;//账号级别
	private Double discount;//折扣比例
	private Integer isAble;//账号状态，是否已激活
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCmLevel() {
		return cmLevel;
	}
	public void setCmLevel(Integer cmLevel) {
		this.cmLevel = cmLevel;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getIsAble() {
		return isAble;
	}
	public void setIsAble(Integer isAble) {
		this.isAble = isAble;
	}
	
	public Member() {
	}
	public Member(Integer id, String customName, String pwd, String tel,
			String email, Integer cmLevel, Double discount, Integer isAble) {
		this.id = id;
		this.customName = customName;
		this.pwd = pwd;
		this.tel = tel;
		this.email = email;
		this.cmLevel = cmLevel;
		this.discount = discount;
		this.isAble = isAble;
	}
	
}
