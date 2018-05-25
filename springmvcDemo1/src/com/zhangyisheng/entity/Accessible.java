package com.zhangyisheng.entity;

import java.sql.Date;

/**
 * 用户评价表
 *
 */
public class Accessible {
	private Integer accNumber;//评价单号
	private String checkNum;
	private String orderId;//预约单号
	private Integer customId;//会员id
	private String customName;//会员名称
	private Integer status;//状态，是否已评
	private Integer evtIndex;//环境指数
	private Integer cleanIndex;//干净清洁指数
	private Integer ftIndex;//服务设施指数
	private Integer serverIndex;//服务温馨指数
	private String content;//评价内容
	private String accTime;//评价时间
	private Order order;//预约信息
	private Member member;//会员信息
	public Integer getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
	}
	
	public String getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getCustomId() {
		return customId;
	}
	public void setCustomId(Integer customId) {
		this.customId = customId;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getEvtIndex() {
		return evtIndex;
	}
	public void setEvtIndex(Integer evtIndex) {
		this.evtIndex = evtIndex;
	}
	public Integer getCleanIndex() {
		return cleanIndex;
	}
	public void setCleanIndex(Integer cleanIndex) {
		this.cleanIndex = cleanIndex;
	}
	public Integer getFtIndex() {
		return ftIndex;
	}
	public void setFtIndex(Integer ftIndex) {
		this.ftIndex = ftIndex;
	}
	public Integer getServerIndex() {
		return serverIndex;
	}
	public void setServerIndex(Integer serverIndex) {
		this.serverIndex = serverIndex;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAccTime() {
		return accTime;
	}
	public void setAccTime(String accTime) {
		this.accTime = accTime;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Accessible(Integer accNumber, String checkNum, String orderId,
			Integer customId, String customName, Integer status,
			Integer evtIndex, Integer cleanIndex, Integer ftIndex,
			Integer serverIndex, String content, String accTime, Order order,
			Member member) {
		this.accNumber = accNumber;
		this.checkNum = checkNum;
		this.orderId = orderId;
		this.customId = customId;
		this.customName = customName;
		this.status = status;
		this.evtIndex = evtIndex;
		this.cleanIndex = cleanIndex;
		this.ftIndex = ftIndex;
		this.serverIndex = serverIndex;
		this.content = content;
		this.accTime = accTime;
		this.order = order;
		this.member = member;
	}
	public Accessible() {
	}
	
}
