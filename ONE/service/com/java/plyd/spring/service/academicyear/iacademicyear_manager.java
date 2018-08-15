package com.java.plyd.spring.service.academicyear;

import java.util.List;

import com.java.plyd.spring.entity.academicyear;


public interface iacademicyear_manager
{
	public void insert(academicyear a);
	public void update(academicyear a);
	public void delete(int id);
	List<academicyear> selectAll();
	academicyear selectByID(int id);
}
