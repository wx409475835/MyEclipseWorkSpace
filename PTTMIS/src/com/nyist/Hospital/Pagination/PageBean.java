package com.nyist.Hospital.Pagination;

import java.util.Arrays;
import java.util.List;

public class PageBean {
	//这个PageBean 是用来承载页面数据的  包括 导航条和数据两部分
	//数据部分
	private List list;				//页面数据集合
	//导航条部分		
	private int totalrecord;			//总共多少条记录
	private int pagesize;				//页面大小
	private int totalpage;				//总页数
	private int currentpage;			//当前页
	private int previouspage;			//上一页
	private int nextpage;				//下一页
	private int[] pagebar = new int[]{};//页码条
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public int getTotalpage() {
		//获得总页数
		// 总记录数     页面大小       页数
		//   100         5        20
		//   101         5        21
		//   99          5        20
		if(this.totalrecord % this.pagesize == 0){						//正好是整数倍的情况
			this.totalpage = this.totalrecord / this.pagesize;
		}else{
			this.totalpage = (this.totalrecord / this.pagesize) + 1;	//不是整数倍的情况  页数+1
		}
		System.out.println("totalpage:"+totalpage);
		return totalpage;
	}
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPreviouspage() {
		if(currentpage - 1 < 1){
			this.previouspage=this.currentpage;
		}else {
			this.previouspage = this.currentpage-1;
		}
		return previouspage;
	}
	public int getNextpage() {
		if(this.currentpage+1>this.totalpage){
			this.nextpage = this.totalpage;
		}else {
			this.nextpage = this.currentpage+1;
		}
		return nextpage;
	}
	public int[] getPagebar() {
		// 页码条显示
		// 2.第二种方式页码条显示 动态页码条
		int pagebar[] = null;
		int startpage;
		int endpage;
		if (this.totalpage <= 10) {
			pagebar = new int[this.totalpage];
			startpage = 1;
			endpage = this.totalpage;
		} else {
			pagebar = new int[10];
			startpage = this.currentpage - 4;
			endpage = this.currentpage + 5;
			// 总页数30 3 -1
			// 总页数30 29 34 21 30
			if (startpage < 1) {
				startpage = 1;
				endpage = 10;
			}
			// 最后显示的页数 大于 总页码数的情况
			if (endpage > this.totalpage) {
				endpage = this.totalpage;
				startpage = this.totalpage - 9;
			}
		}
		// 将 页码条 填充数组
		int index = 0;
		for (int i = startpage; i <= endpage; i++) {
			pagebar[index++] = i;
		}
		this.pagebar = pagebar;
		return pagebar;
	}
	@Override
	public String toString() {
		return "PageBean [list=" + list + ", totalrecord=" + totalrecord + ", pagesize=" + pagesize + ", totalpage="
				+ totalpage + ", currentpage=" + currentpage + ", previouspage=" + previouspage + ", nextpage="
				+ nextpage + ", pagebar=" + Arrays.toString(pagebar) + "]";
	}
}
