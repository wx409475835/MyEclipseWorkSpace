package com.nyist.cn.Pagination;


import java.util.Arrays;
import java.util.List;

import com.nyist.cn.mode.person;


public class PageBean {
	private List<person> list;				
	private int totalrecord;
	private int pagesize;
	private int totalpage;
	private int currentpage;
	private int previouspage;
	private int nextpage;
	private int[] pagebar = new int[]{};
	public List<person> getList() {
		return list;
	}
	public void setList(List<person> list) {
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
		//100  5  20
		//101  5  21
		//99   5  20
		if(this.totalrecord%this.pagesize==0){
			this.totalpage = this.totalrecord/this.pagesize;
		}else{
			this.totalpage = (this.totalrecord/this.pagesize)+1;
		}
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
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int[] getPagebar() {
		//1.第一种方式  页码条显示
		/*int[] pagebar = new int[this.totalpage];
		for(int i=1;i<=this.totalpage;i++){
			pagebar[i-1] = i;
		}*/
		
		//2.第二种方式页码条显示    动态页码条
		int pagebar[] = null;
		int startpage;
		int endpage;
		if(this.totalpage <= 10){
			pagebar = new int[this.totalpage];
			startpage = 1;
			endpage = this.totalpage;
		}else{
			pagebar = new int[10];
			startpage = this.currentpage - 4;
			endpage = this.currentpage + 5;
			//总页数30      3    -1
			//总页数30      29   34   21     30
			if(startpage < 1){
				startpage = 1;
				endpage = 10;
			}
			
			//最后显示的页数  大于  总页码数的情况
			if(endpage > this.totalpage){
				endpage = this.totalpage;
				startpage = this.totalpage - 9;
			}
		}
		
		//将  页码条 填充数组
		int index = 0;
		for (int i = startpage; i <=endpage; i++) {
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
