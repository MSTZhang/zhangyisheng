package com.zhangyisheng.entity;

import java.util.List;

public class AccessGoodRate {
	private Double goodRate;//������
	private Integer num;//��������
	private Double evtScore;//����ָ���ۺϵ÷�
	private Double cleanScore;//���ָ���ۺϵ÷�
	private Double ftScore;//������ʩָ���ۺϵ÷�
	private Double serverScore;//������ָܰ���ۺϵ÷�
	private List<AccessExclu>accessExclus;//
	public Double getGoodRate() {
		return goodRate;
	}
	public void setGoodRate(Double goodRate) {
		this.goodRate = goodRate;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getEvtScore() {
		return evtScore;
	}
	public void setEvtScore(Double evtScore) {
		this.evtScore = evtScore;
	}
	public Double getCleanScore() {
		return cleanScore;
	}
	public void setCleanScore(Double cleanScore) {
		this.cleanScore = cleanScore;
	}
	public Double getFtScore() {
		return ftScore;
	}
	public void setFtScore(Double ftScore) {
		this.ftScore = ftScore;
	}
	public Double getServerScore() {
		return serverScore;
	}
	public void setServerScore(Double serverScore) {
		this.serverScore = serverScore;
	}
	public List<AccessExclu> getAccessExclus() {
		return accessExclus;
	}
	public void setAccessExclua(List<AccessExclu> accessExclus) {
		this.accessExclus = accessExclus;
	}
	public AccessGoodRate(Double goodRate, Integer num, Double evtScore,
			Double cleanScore, Double ftScore, Double serverScore,
			List<AccessExclu> accessExclus) {
		this.goodRate = goodRate;
		this.num = num;
		this.evtScore = evtScore;
		this.cleanScore = cleanScore;
		this.ftScore = ftScore;
		this.serverScore = serverScore;
		this.accessExclus = accessExclus;
	}
	public AccessGoodRate() {
	}
	
}
