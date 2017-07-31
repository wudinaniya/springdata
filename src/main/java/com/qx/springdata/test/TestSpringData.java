package com.qx.springdata.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qx.springdata.Person;
import com.qx.springdata.PersonRepository;

public class TestSpringData {
	
	private ApplicationContext context;
	private PersonRepository personRepository;
	
	@org.junit.Before  //该注解含义在执行@Test注解之前先执行这个代码
	public void Before(){
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		personRepository=context.getBean(PersonRepository.class);
		System.out.println("测试前");
	}
	
	@Test
	public void testHellord(){
		Person person = personRepository.getByLastName("张三");
		System.out.println(person);
		
	}
	
	@Test
	public void testKeyWords(){
//		List<Person> list = personRepository.getByLastNameStartingWithAndIdLessThan("张", 8);
//		System.out.println(list);
		
//		List<Person> list = personRepository.getByLastNameEndingWithAndIdLessThan("c", 8);
//		System.out.println(list);
		
		//使用 Arrays.asList(T... a)可以把传进来的一个可变参数数组快速转变成集合
		List<Person> list = personRepository.getByEmailIn(Arrays.asList("bb@163.com","cc@163.com","zs@163.com"));
		System.out.println(list);
		
		List<Person> list2=personRepository.getByEmailInAndIdLessThan(Arrays.asList("bb@163.com","cc@163.com","zs@163.com"), 6);
		System.out.println(list2);
	}
	
	//查询关联数据
	@Test
	public void testKeyWords2(){
		List<Person> list = personRepository.getByAddressIdGreaterThan(110);
		System.out.println(list);
		
		List<Person> list2=personRepository.getByAddress_IdGreaterThan(110);
		System.out.println(list2);
	}
	
	
}
