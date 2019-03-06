package com.nyist.domain;

import java.util.List;

public class PageBean<E> {
	private List<E> list;
	private Integer currPage;
	private Integer pageSize;
	private Integer totalCount;
	private Integer totalPage;
	
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return (int)(Math.ceil(totalCount*1.0/pageSize));
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public PageBean(List<E> list, Integer currPage, Integer pageSize, Integer totalCount) {
		super();
		this.list = list;
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	public PageBean() {
		super();
	}
	@Override
	public String toString() {
		return "PageBean [list=" + list + ", currPage=" + currPage + ", pageSize=" + pageSize + ", totalPage="
				+ totalPage + ", totalCount=" + totalCount + "]";
	}
	
}
