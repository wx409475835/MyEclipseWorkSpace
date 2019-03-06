package com.nyist.cn.Service.Impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nyist.cn.Dao.PersonMapper;
import com.nyist.cn.Pagination.PageBean;
import com.nyist.cn.Pagination.QueryInfo;
import com.nyist.cn.Pagination.QueryResult;
import com.nyist.cn.Service.PersonService;
import com.nyist.cn.mode.person;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonMapper personmapper;
	
	@Override
	public List<person> SelectAll() {
		return personmapper.SelectAll();
	}

	@Override
	public void AddInfo(person per) {
		personmapper.AddInfo(per);
	}

	@Override
	public void DeleteInfo(String id) {
		personmapper.DeleteInfo(id);
	}

	@Override
	public PageBean pageQuery(QueryInfo queryInfo) {
		PageBean bean = new PageBean();
		QueryResult qr = new QueryResult();
		List<person> persons = personmapper.QueryLimitList(queryInfo.getStartindex(), queryInfo.getPagesize());
		int totalrecord = personmapper.QueryTotalRecord();
		qr.setList(persons);
		qr.setTotalrecord(totalrecord);
		bean.setCurrentpage(queryInfo.getCurrentpage());
		bean.setList(persons);
		bean.setPagesize(queryInfo.getPagesize());
		bean.setTotalrecord(qr.getTotalrecord());
		/*bean.setPreviouspage(queryInfo.getCurrentpage()-1);
		bean.setNextpage(queryInfo.getCurrentpage()+1);*/
		System.out.println("=====================================================================TotalPage:"+bean.getTotalpage());
		System.out.println("=====================================================================NextPage:"+bean.getNextpage());
		System.out.println("=====================================================================PageSize:"+bean.getPagesize());
		System.out.println("=====================================================================PreviousPage:"+bean.getPreviouspage());
		System.out.println("=====================================================================PageBar:"+bean.getPagebar().toString());
		System.out.println("=====================================================================Totalrecord:"+bean.getTotalrecord());
		System.out.println("=====================================================================Currentpage:"+bean.getCurrentpage());
		return bean;
	}

	@Override
	public List<person> QueryLimitList(int startIndex, int pagesize) {
		return personmapper.QueryLimitList(startIndex, pagesize);
	}

	@Override
	public int QueryTotalRecord() {
		return personmapper.QueryTotalRecord();
	}

	@Override
	public List<person> search(String key) {
		return personmapper.search(key);
	}
}
