package com.zhangyisheng.entity;

import java.util.List;

public class Activity {
	private Integer acId;
	private Integer roomTypId;
	private String acName;
	private Double acPrice;
	private Integer freeRoom;
	private RoomType roomType;
	private List<Room>rooms;
	public Integer getAcId() {
		return acId;
	}
	public void setAcId(Integer acId) {
		this.acId = acId;
	}
	public Integer getRoomTypId() {
		return roomTypId;
	}
	public void setRoomTypId(Integer roomTypId) {
		this.roomTypId = roomTypId;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public Double getAcPrice() {
		return acPrice;
	}
	public void setAcPrice(Double acPrice) {
		this.acPrice = acPrice;
	}
	public Integer getFreeRoom() {
		return freeRoom;
	}
	public void setFreeRoom(Integer freeRoom) {
		this.freeRoom = freeRoom;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public Activity() {
	}
	public Activity(Integer acId, Integer roomTypId, String acName,
			Double acPrice, Integer freeRoom, RoomType roomType,
			List<Room> rooms) {
		this.acId = acId;
		this.roomTypId = roomTypId;
		this.acName = acName;
		this.acPrice = acPrice;
		this.freeRoom = freeRoom;
		this.roomType = roomType;
		this.rooms = rooms;
	}
	
}
