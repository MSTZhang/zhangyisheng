package com.zhangyisheng.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *预约详细表 
 *
 */
public class Order {
	private String orderId;//订单id
	private String customName;//客户姓名
	private String customTel;//客户电话
	private Integer rtyId;//房间类型
	private Integer rmId;//房间id
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkTime;//入住时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date leaveTime;//离店时间
	private Integer num;//入住人数
	private Integer days;//入住天数
	private String bookTime;//预订时间
	private Integer odStatus;//订单状态
	private Integer isApply;//是否已支付
	private String remark;//备注
	private Double totalPrice;//订单总价
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
