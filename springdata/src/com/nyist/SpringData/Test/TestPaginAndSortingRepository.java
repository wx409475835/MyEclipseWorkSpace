package com.nyist.SpringData.Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nyist.SpringData.Entity.Person;


public class TestPaginAndSortingRepository {
	
	private static ApplicationContext ctx = null;
	private static PagingAndSortingRepository pagingAndSortingRepository;
	static{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		pagingAndSortingRepository = ctx.getBean(PagingAndSortingRepository.class);
	}
	
	@Test
	public void testPagingAndSortingRepository(){
		//pageNo 从 0 开始
		int pageNo = 5 - 1;
		int pageSize = 5;
		//Pageable 接口通常使用的是PageRequest 实现类,其中封装了实现分页的信息
		//排序相关
		//Order 是具体针对某一个属性进行升序还是降序
		Order order1 = new Order(Direction.DESC,"id");
		Order order2 = new Order(Direction.ASC,"email");
		Sort sort = new Sort(order1,order2);
		PageRequest pageRequest = new PageRequest(pageNo, pageSize,sort);
		Page<Person> page = pagingAndSortingRepository.findAll(pageRequest);
		System.out.println("总记录数:"+page.getTotalElements());
		System.out.println("当前第几页:"+Integer.valueOf(page.getNumber())+1);
		System.out.println("当前页面的List:"+page.getContent());
		System.out.println("总页数:"+page.getTotalPages());
		System.out.println("当前页面的记录数:"+page.getNumberOfElements());
	}
}
