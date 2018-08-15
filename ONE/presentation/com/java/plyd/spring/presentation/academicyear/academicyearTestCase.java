package com.java.plyd.spring.presentation.academicyear;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.plyd.spring.entity.academicyear;
import com.java.plyd.spring.service.academicyear.iacademicyear_manager;


public class academicyearTestCase {

	static iacademicyear_manager iacademicyear_manager;

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring-beans.xml");
		BeanFactory factory = context;

		iacademicyear_manager = (iacademicyear_manager) factory.getBean("academicyear_manager");
		
		academicyear a=new academicyear();
//		a.setName("2020-2021");
//		 iacademicyear_manager.insert(a);
//		 
//		 a.setId(7);
//		 a.setName("Test 2020-2021");
//		 iacademicyear_manager.delete(7);

		List<academicyear> list = new ArrayList<academicyear>();

		list = iacademicyear_manager.selectAll();
		for (academicyear ayear : list) {

			System.out.println("ID"+ayear.getid()+ayear.getinvoicename());

		}
	}
}
