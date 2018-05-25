package com.zhangyisheng.entity;

import java.util.List;

public class RoomType {
	private Integer roomTypeId;//房间类型id
	private String roomTypeName;//房间类型名称
	private String bedType;//床型
	private Integer bedNum;//床的数量
	private Double area;//房间面积
	private String imgUrl;//房间图片
	private Double price;//房间价格
	private List<Flexible> flexibles;//房间类型对应的活动
	private List<Room>rooms;//房间
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public Integer getBedNum() {
		return bedNum;
	}
	public void setBedNum(Integer bedNum) {
		this.bedNum = bedNum;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<Flexible> getFlexibles() {
		return flexibles;
	}
	public void setFlexibles(List<Flexible> flexibles) {
		this.flexibles = flexibles;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public RoomType() {
	}
	public RoomType(Integer roomTypeId, String roomTypeName, String bedType,
			Integer bedNum, Double area, String imgUrl, Double price,
			List<Flexible> flexibles, List<Room> rooms) {
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.bedType = bedType;
		this.bedNum = bedNum;
		this.area = area;
		this.imgUrl = imgUrl;
		this.price = price;
		this.flexibles = flexibles;
		this.rooms = rooms;
	}
	@Override
	public String toString() {
		return "RoomType [roomTypeId=" + roomTypeId + ", roomTypeName="
				+ roomTypeName + ", bedType=" + bedType + ", bedNum=" + bedNum
				+ ", area=" + area + ", imgUrl=" + imgUrl + ", price=" + price
				+ ", flexibles=" + flexibles + ", rooms=" + rooms + "]";
	}
	
}
