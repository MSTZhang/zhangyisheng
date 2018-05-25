package com.zhangyisheng.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
/*
 * 入住登记表
 */
public class CheckIn {
	private String checkNumber;//入住单号
	private Integer userId;
	private Integer rmId;//房间id
	private Integer rtyId;//房间类型id
	private Integer cmLevel;//房客类型
	private String customName;//顾客姓名
	private Integer sex;//性别
	private String paperType;//证件类型
	private String paperNumber;//证件号码
	private String adress;//地址
	private Integer num;//入住人数
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkTime;//入住时间
	private Integer days;//入住天数
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date leaveTime;//离店时间
	private Double forgift;//押金
	private Integer status;//折扣比例
	private String balanceNumber;//结账单号
	private Integer operatorId;//操作员id
	private Room room;//入住房间
	private RoomType roomType;//房间类型
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRmId() {
		return rmId;
	}
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}
	public Integer getRtyId() {
		return rtyId;
	}
	public void setRtyId(Integer rtyId) {
		this.rtyId = rtyId;
	}
	
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	public String getPaperNumber() {
		return paperNumber;
	}
	public void setPaperNumber(String paperNumber) {
		this.paperNumber = paperNumber;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Double getForgift() {
		return forgift;
	}
	public void setForgift(Double forgift) {
		this.forgift = forgift;
	}
	public String getBalanceNumber() {
		return balanceNumber;
	}
	public void setBalanceNumber(String balanceNumber) {
		this.balanceNumber = balanceNumber;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	public Integer getCmLevel() {
		return cmLevel;
	}
	public void setCmLevel(Integer cmLevel) {
		this.cmLevel = cmLevel;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public CheckIn() {
	}
	public CheckIn(String checkNumber, Integer userId, Integer rmId,
			Integer rtyId, Integer cmLevel, String customName, Integer sex,
			String paperType, String paperNumber, String adress, Integer num,
			Date checkTime, Integer days, Date leaveTime, Double forgift,
			Integer status, String balanceNumber, Integer operatorId,
			Room room, RoomType roomType) {
		this.checkNumber = checkNumber;
		this.userId = userId;
		this.rmId = rmId;
		this.rtyId = rtyId;
		this.cmLevel = cmLevel;
		this.customName = customName;
		this.sex = sex;
		this.paperType = paperType;
		this.paperNumber = paperNumber;
		this.adress = adress;
		this.num = num;
		this.checkTime = checkTime;
		this.days = days;
		this.leaveTime = leaveTime;
		this.forgift = forgift;
		this.status = status;
		this.balanceNumber = balanceNumber;
		this.operatorId = operatorId;
		this.room = room;
		this.roomType = roomType;
	}
	
}
