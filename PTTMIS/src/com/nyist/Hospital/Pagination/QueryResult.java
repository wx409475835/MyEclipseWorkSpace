package com.nyist.Hospital.Pagination;

import java.util.List;

public class QueryResult {
	//QueryResult集合  是通过数据可查询出来的集合
	private List list;			//查询出来的数据集合
	private int totalrecord;		//总记录数目
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
}
