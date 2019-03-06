package com.nyist.Jpa.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//这里边必须又select 
@NamedQuery(name="testNameQuery",query="select c from Customer c where c.id = ?1")
@Cacheable(true)
@Table(name="JPA_CUSTOMER")															//需要生成的数据表名称
@Entity																				//表明这是一个持久化类 对象
public class Customer {
	@Id	
	@Column(name="jpa_id",nullable=false,unique=true,length=50)						//映射得 列名												//Id  主键
//	strategy 主键的生成策略改变成功为 用table表的方式生成主键
//	generator  指定生成器
//	@GeneratedValue(strategy=GenerationType.TABLE,generator="ID_GENERATOR")			//生成值得策略
//	name ID_GENERATOR 表生成策略的名称  table 生成主键策略的表	pkColumnName	生成主键的列		pkColumnValue	生成值
//	allocationSize	增长幅度 为 1 	initalValue	初始化值为1
//	@TableGenerator(name="ID_GENERATOR",
//		table="JPA_GENERATOR_ID",
//		pkColumnName="person_id",
//		pkColumnValue="ID_VAL",
//		allocationSize=1,
//		initialValue=1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="jpa_last_name",length=50,nullable=false)							//映射数据库字段
	private String lastName;
	@Column(length=50,nullable=false,name="jpa_email")
	private String email;
	@Column(name="jpa_age",length=10,nullable=false)
	private Integer age;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="jap_createTime")
	private Date createTime;
	@Temporal(TemporalType.DATE)
	@Column(name="jpa_birth")
	private Date birth;
	//映射 单向一对多的关联映射	
	//使用 @OneToMany 来映射 1-n 的关联关系
	//@OneToMany 可以使用属性 fetch 属性来指定 加载方式 懒加载和急加载
	//注意：在1的一端的@OneToMany 中使用 mapperedBy 属性,则@OneToMany端就不能使用@JoinColumn属性了  但是 也没有外键约束关联了
	//@JoinColumn(name="customer_id")
	//可以通过 修改 cascade 的属性 来修改删除策略。cascade = {CascadeType.REMOVE}  实现级联删除策略
	@OneToMany(fetch=FetchType.LAZY,cascade={CascadeType.REMOVE},mappedBy="customer")
	private Set<Order> orders =  new HashSet<Order>();

	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Customer() {
		super();
	}
	
	//这种工具方法  不需要映射为数据裤的 字段
	//@Transient  用来指定 不被映射成数据裤的字段
	@Transient
	public String getInfo(){
		return "lastName:"+lastName+", email:"+email;
	}
	
	public Customer(Integer id, String lastName, String email, Integer age) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
	}
	protected Customer(String lastName, Integer age) {
		super();
		this.lastName = lastName;
		this.age = age;
	}
	
	
}
