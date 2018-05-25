package com.zhangyisheng.entity;

import java.util.List;

public class OrderPage {
	private List<Order> orders;
	private Integer page;
	private Integer totalCount;//总记录数
	private Integer currentPage;//当前页
	private Integer totalPage;//共计多少页
	private Integer lastPage;
	private Integer nextPage;
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public OrderPage(List<Order> orders, Integer page, Integer totalCount,
			Integer currentPage, Integer totalPage, Integer lastPage,
			Integer nextPage) {
		this.orders = orders;
		this.page = page;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.lastPage = lastPage;
		this.nextPage = nextPage;
	}
	public OrderPage() {
	}
}
