package com.nyist.cn.Pagination;

public class QueryInfo {
	private int currentpage = 1;			//用户当前看的页
	private int pagesize = 8;				//页面大小
	private int startindex;					//记住 用户看的页的数据在数据库的起始位置
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getStartindex() {
		this.startindex = (this.currentpage -1)*this.pagesize;
		return startindex;
	}
	
	
	
	
}
