package com.zhangyisheng.entity;

public class AccessEx {
	private Integer accNumber;//ÆÀ¼Ûµ¥ºÅ
	private String hotelName;
	private String date;
	private Double totalPrice;
	private Integer status;
	public Integer getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public AccessEx(Integer accNumber, String hotelName, String date,
			Double totalPrice, Integer status) {
		this.accNumber = accNumber;
		this.hotelName = hotelName;
		this.date = date;
		this.totalPrice = totalPrice;
		this.status = status;
	}
	public AccessEx() {
	}
	
}
