package com.qx.springdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 给类同时加@Entity 和 @Table的原因:
 * 当你从数据库读取数据时,由于你要读取的表映射有实体类(@Entity注解的),那么后台会自动帮你
 * 实例化一个对象:
 * 创建一个Entity Bean对象相当于新建一条记录,删除一个Entity Bean对象会同时从数据库中删除
 * 对应记录,修改一个Entity Bean时,容器会自动将Entity Bean的状态和数据库同步.
 * @author dell
 *
 */
@Entity  //该注解用于指明这是一个实体bean
@Table(name="jpa_addresses") //该注解用于指明Entity所要映射到的数据库表
public class Address {

	private Integer id;
	private String provience;
	private String city;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvience() {
		return provience;
	}
	public void setProvience(String provience) {
		this.provience = provience;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", provience=" + provience + ", city=" + city + "]";
	}
	
}
