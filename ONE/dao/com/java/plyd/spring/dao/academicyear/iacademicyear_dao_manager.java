package com.java.plyd.spring.dao.academicyear;

import java.util.List;

import com.java.plyd.spring.entity.academicyear;

public interface iacademicyear_dao_manager {
	public void insert(academicyear a);
	public void update(academicyear a);
	public void delete(int id);
	public List<academicyear> selectAll();
	public academicyear selectByID(int id);
	
}
