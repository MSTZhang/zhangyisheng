package com.zhangyisheng.entity;

public class Member {
	private Integer id;
	private String customName;//��������
	private String pwd;//��¼����
	private String tel;//��ϵ�绰
	private String email;//����
	private Integer cmLevel;//�˺ż���
	private Double discount;//�ۿ۱���
	private Integer isAble;//�˺�״̬���Ƿ��Ѽ���
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
