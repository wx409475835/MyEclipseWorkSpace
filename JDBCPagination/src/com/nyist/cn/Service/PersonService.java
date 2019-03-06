package com.nyist.cn.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nyist.cn.Pagination.PageBean;
import com.nyist.cn.Pagination.QueryInfo;
import com.nyist.cn.mode.person;

public interface PersonService {
	/*查询所有的数据*/
	public List<person> SelectAll();
	/**
	 * 添加数据
	 * @param per
	 */
	public void AddInfo(person per);
	/**
	 * 删除  指定的消息记录
	 * @param id
	 */
	public void DeleteInfo(String id);
	/**
	 * 查询 jsp 页面数据
	 * @param queryInfo
	 * @return
	 */
	public PageBean pageQuery(QueryInfo queryInfo); 
	/**
	 * 查询 QueryResult 类中的List集合
	 * @param startIndex
	 * @param pagesize
	 * @return
	 */
	public List<person> QueryLimitList(@Param("startIndex")int startIndex,@Param("pagesize")int pagesize);
	/**
	 * 查询 总记录数
	 * @return
	 */
	public int QueryTotalRecord();
	
	//动态查询
	public List<person> search(String key);
}
