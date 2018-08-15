package com.java.plyd.spring.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicBeanFactory {
	
	private static HashMap<String, Object> beanContainer = new HashMap<String,Object>();//hashmap obj name beancontainer;
	private List<String> beanList = new ArrayList<String>();//crate list like a array;
	
	public static Object getBean(String beanName)
	{
		 Object object = new Object();
		 object = beanContainer.get(beanName);
		return object;
	}
	
	public void BeanController()
	{
		beanList.add("academicyear_manager");
	//	beanList.add("cla_manager");	
		//beanList.add("grade_manager");
		
		Object object = new Object();
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beans.xml");//spring beans was here;
		BeanFactory beanfactory = (BeanFactory) context;
	    for(String beanName : beanList)
	    {
			 object = beanfactory.getBean(beanName);
			 beanContainer.put(beanName, object);
		}
	}
	
	public BasicBeanFactory( ){
		BeanController();
	}


}
