package com.zhangyisheng.entity;

import java.sql.Date;

/**
 * 
 *�����
 */
public class Balance {
	private String balanceNumber;//���㵥��
	private String checkNumber;//��ס����
	private Integer realDays;//ʵס����
	private Double price;//���
	private String balanceTime;//����ʱ��
	private CheckIn checkIn;//��ס��Ϣ
	
	public String getBalanceNumber() {
		return balanceNumber;
	}
	public void setBalanceNumber(String balanceNumber) {
		this.balanceNumber = balanceNumber;
	}
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	public Integer getRealDays() {
		return realDays;
	}
	public void setRealDays(Integer realDays) {
		this.realDays = realDays;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBalanceTime() {
		return balanceTime;
	}
	public void setBalanceTime(String balanceTime) {
		this.balanceTime = balanceTime;
	}
	public CheckIn getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(CheckIn checkIn) {
		this.checkIn = checkIn;
	}
	public Balance() {
	}
	public Balance(String balanceNumber, String checkNumber, Integer realDays,
			Double price, String balanceTime, CheckIn checkIn) {
		this.balanceNumber = balanceNumber;
		this.checkNumber = checkNumber;
		this.realDays = realDays;
		this.price = price;
		this.balanceTime = balanceTime;
		this.checkIn = checkIn;
	}
	
}
