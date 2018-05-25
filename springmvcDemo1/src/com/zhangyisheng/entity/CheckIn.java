package com.zhangyisheng.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
/*
 * ��ס�ǼǱ�
 */
public class CheckIn {
	private String checkNumber;//��ס����
	private Integer userId;
	private Integer rmId;//����id
	private Integer rtyId;//��������id
	private Integer cmLevel;//��������
	private String customName;//�˿�����
	private Integer sex;//�Ա�
	private String paperType;//֤������
	private String paperNumber;//֤������
	private String adress;//��ַ
	private Integer num;//��ס����
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkTime;//��סʱ��
	private Integer days;//��ס����
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date leaveTime;//���ʱ��
	private Double forgift;//Ѻ��
	private Integer status;//�ۿ۱���
	private String balanceNumber;//���˵���
	private Integer operatorId;//����Աid
	private Room room;//��ס����
	private RoomType roomType;//��������
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
