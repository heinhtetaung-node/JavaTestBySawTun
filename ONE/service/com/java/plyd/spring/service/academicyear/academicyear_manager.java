package com.java.plyd.spring.service.academicyear;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.java.plyd.spring.entity.academicyear;
import com.java.plyd.spring.dao.academicyear.*;

@Service(value = "academicyear_manager")
public class academicyear_manager implements iacademicyear_manager {

	@Resource(name = "academicyear_dao_manager")
	private academicyear_dao_manager academicyear_dao_manager;



	@Override
	public List<academicyear> selectAll()
	{
		List<academicyear> list=new ArrayList<academicyear>();
		try {
			list=academicyear_dao_manager.selectAll();

		} catch (Exception ie) {
			ie.printStackTrace();
		}
		return list;
	}



	@Override
	public academicyear selectByID(int id) {
		// TODO Auto-generated method stub
		academicyear a=new academicyear();
		try {
			a=academicyear_dao_manager.selectByID(id);

		} catch (Exception ie) {
			ie.printStackTrace();
		}
		return a;
	}



	@Override
	public void insert(academicyear a) {
		// TODO Auto-generated method stub
		try {
			academicyear_dao_manager.insert(a);

		} catch (Exception ie) {
			ie.printStackTrace();
		}
		
	}



	@Override
	public void update(academicyear a) {
		// TODO Auto-generated method stub
		try {
			academicyear_dao_manager.update(a);

		} catch (Exception ie) {
			ie.printStackTrace();
		}

	}



	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			academicyear_dao_manager.delete(id);

		} catch (Exception ie) {
			ie.printStackTrace();
		}

	}
	
}
