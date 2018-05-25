package com.zhangyisheng.entity;

import java.util.List;

public class Flexible {
	private Integer acId;
	private String acName;
	private String acUrl;
	private String imgUrl;
	private Double acPrice;
	private List<Room> rooms;
	public Integer getAcId() {
		return acId;
	}
	public void setAcId(Integer acId) {
		this.acId = acId;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public String getAcUrl() {
		return acUrl;
	}
	public void setAcUrl(String acUrl) {
		this.acUrl = acUrl;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Double getAcPrice() {
		return acPrice;
	}
	public void setAcPrice(Double acPrice) {
		this.acPrice = acPrice;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public Flexible() {
	}
	public Flexible(Integer acId, String acName, String acUrl, String imgUrl,
			Double acPrice, List<Room> rooms) {
		this.acId = acId;
		this.acName = acName;
		this.acUrl = acUrl;
		this.imgUrl = imgUrl;
		this.acPrice = acPrice;
		this.rooms = rooms;
	}
	@Override
	public String toString() {
		return "Flexible [acId=" + acId + ", acName=" + acName + ", acUrl="
				+ acUrl + ", imgUrl=" + imgUrl + ", acPrice=" + acPrice
				+ ", rooms=" + rooms + "]";
	}
	
}
