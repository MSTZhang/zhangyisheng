package com.zhangyisheng.entity;

import java.sql.Date;

/**
 * �û����۱�
 *
 */
public class Accessible {
	private Integer accNumber;//���۵���
	private String checkNum;
	private String orderId;//ԤԼ����
	private Integer customId;//��Աid
	private String customName;//��Ա����
	private Integer status;//״̬���Ƿ�����
	private Integer evtIndex;//����ָ��
	private Integer cleanIndex;//�ɾ����ָ��
	private Integer ftIndex;//������ʩָ��
	private Integer serverIndex;//������ָܰ��
	private String content;//��������
	private String accTime;//����ʱ��
	private Order order;//ԤԼ��Ϣ
	private Member member;//��Ա��Ϣ
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
