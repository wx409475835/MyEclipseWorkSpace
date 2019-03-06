package com.nyist.Hospital.Pagination;

public class QueryInfo {
	//数据库分页技术实现     页面数据传递
	private int currentpage = 1;		//用户当前看的页
	private int pagesize = 12;			//页面大小
	private int startindex ;
	//数据库的起始页
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
		//通过当前用户看的页 和 页面大小  可以计算出  数据库的起始页
		this.startindex = (this.currentpage -1 )* this.pagesize;
		return startindex;
	}
}
