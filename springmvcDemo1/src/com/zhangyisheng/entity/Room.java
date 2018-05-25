package com.zhangyisheng.entity;

public class Room {
	private Integer roomId;
	private Integer acId;
	private Integer roomTypeId;
	private Integer floor;
	private Integer rmStatus;//房价状态
	private RoomType roomType;//房间类型
	private Flexible flexible;//房间的优惠活动
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	
	
	public Integer getRmStatus() {
		return rmStatus;
	}
	public void setRmStatus(Integer rmStatus) {
		this.rmStatus = rmStatus;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	public Flexible getFlexible() {
		return flexible;
	}
	public void setFlexible(Flexible flexible) {
		this.flexible = flexible;
	}
	public Integer getAcId() {
		return acId;
	}
	public void setAcId(Integer acId) {
		this.acId = acId;
	}
	
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public Room() {
	}
	
	public Room(Integer roomId, Integer acId, Integer roomTypeId,
			Integer floor, Integer rmStatus, RoomType roomType,
			Flexible flexible) {
		this.roomId = roomId;
		this.acId = acId;
		this.roomTypeId = roomTypeId;
		this.floor = floor;
		this.rmStatus = rmStatus;
		this.roomType = roomType;
		this.flexible = flexible;
	}
}
