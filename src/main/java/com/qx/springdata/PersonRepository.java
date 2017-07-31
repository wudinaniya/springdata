package com.qx.springdata;

import java.util.List;

import org.springframework.data.repository.Repository;

/**
 * 操作person类的接口
 * 需要继承自Repository
 * 参1: 代表当前操作的实体类
 * 参2: 代表实体类的主键类型
 * @author dell
 *
 *Repository是springdata的核心接口,这个接口的实现规定了spring data操作数据库的规范--命名规范
 *查询是以get或者是find或者是read开头
 */
public interface PersonRepository extends Repository<Person, Integer> {
	
	//根据名字查找
	Person getByLastName(String lastName);
	
	//查询名字以xxx开头同时id小于xxx的值
	List<Person> getByLastNameStartingWithAndIdLessThan(String lastName,Integer id);
	
	List<Person> getByLastNameEndingWithAndIdLessThan(String lastName,Integer id);
	
	//查询对应邮件的人
	List<Person> getByEmailIn(List<String> emails);
	//查询邮件在对应里面里面且id小于某个值的人
	List<Person> getByEmailInAndIdLessThan(List<String> emails,Integer id);
	
	List<Person> getByAddressIdGreaterThan(Integer addressId);//注意,如果对象中存在这个属性,会优先使用自带的属性而不是关联数据
	
	List<Person> getByAddress_IdGreaterThan(Integer addressId);
}
