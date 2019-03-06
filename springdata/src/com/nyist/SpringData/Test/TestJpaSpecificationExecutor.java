package com.nyist.SpringData.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.nyist.SpringData.Entity.Person;
import com.nyist.SpringData.Repostiory.SpringDataJpaSpecificationExecutor;

public class TestJpaSpecificationExecutor {
	
	private static ApplicationContext ctx = null;
	private static SpringDataJpaSpecificationExecutor specificationExecutor = null;
	static{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		specificationExecutor = ctx.getBean(SpringDataJpaSpecificationExecutor.class);
	}
	
	//分页排序
	@Test
	public void testJpaSpecificationExecutor(){
		int pageNo = 3-1;
		int pageSize = 5;
		PageRequest pageable = new PageRequest(pageNo,pageSize);
		//Specification 是查询条件
		Specification<Person> specification = new Specification<Person>() {
			/**
			 * @Param *root:代表查询的实体类
			 * @Param query:可以从中得到Root对象,即告知JPA Criteria 查询要查询哪一个实体类,还可以来添加查询条件,
			 * 还可以结合EntityManager 对象最终查询的TypeQuery 对象。
			 * @Param *cb: CriteriaBuilder 对象。用于创建Criteria 相关对象的工厂,当然可以从中获取Predicate 对象
			 * @return *Predicate 类型：代表一个查询条件。
			 */ 
			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//获得 实体类得 某个属性  eg:获得Id 按照Id 属性排列
				Path path = root.get("id");
				//cb.get()调用get方法 获得查询条件 
				Predicate predicate = cb.gt(path,20);
				//返回查询条件
				return predicate;
			}
			
		};
		Page<Person> page = specificationExecutor.findAll(specification, pageable);
		System.out.println("总记录数:"+page.getTotalElements());
		System.out.println("当前第几页:"+(page.getNumber()+1));
		System.out.println("当前页面的List:"+page.getContent());
		System.out.println("总页数:"+page.getTotalPages());
		System.out.println("当前页面的记录数:"+page.getNumberOfElements());
	}
}
