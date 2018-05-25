package com.zhangyisheng.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *ԤԼ��ϸ�� 
 *
 */
public class Order {
	private String orderId;//����id
	private String customName;//�ͻ�����
	private String customTel;//�ͻ��绰
	private Integer rtyId;//��������
	private Integer rmId;//����id
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkTime;//��סʱ��
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date leaveTime;//���ʱ��
	private Integer num;//��ס����
	private Integer days;//��ס����
	private String bookTime;//Ԥ��ʱ��
	private Integer odStatus;//����״̬
	private Integer isApply;//�Ƿ���֧��
	private String remark;//��ע
	private Double totalPrice;//�����ܼ�
	private Room room;
	private Member member;
	private RoomType roomType;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getCustomTel() {
		return customTel;
	}
	public void setCustomTel(String customTel) {
		this.customTel = customTel;
	}
	public Integer getRtyId() {
		return rtyId;
	}
	public void setRtyId(Integer rtyId) {
		this.rtyId = rtyId;
	}
	public Integer getRmId() {
		return rmId;
	}
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getBookTime() {
		return bookTime;
	}
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	public Integer getOdStatus() {
		return odStatus;
	}
	public void setOdStatus(Integer odStatus) {
		this.odStatus = odStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	public Integer getIsApply() {
		return isApply;
	}
	public void setIsApply(Integer isApply) {
		this.isApply = isApply;
	}
	
	public Order(String orderId, String customName, String customTel,
			Integer rtyId, Integer rmId, Date checkTime, Date leaveTime,
			Integer num, Integer days, String bookTime, Integer odStatus,
			Integer isApply, String remark, Double totalPrice, Room room,
			Member member, RoomType roomType) {
		this.orderId = orderId;
		this.customName = customName;
		this.customTel = customTel;
		this.rtyId = rtyId;
		this.rmId = rmId;
		this.checkTime = checkTime;
		this.leaveTime = leaveTime;
		this.num = num;
		this.days = days;
		this.bookTime = bookTime;
		this.odStatus = odStatus;
		this.isApply = isApply;
		this.remark = remark;
		this.totalPrice = totalPrice;
		this.room = room;
		this.member = member;
		this.roomType = roomType;
	}
	public Order() {
	}
	
}
