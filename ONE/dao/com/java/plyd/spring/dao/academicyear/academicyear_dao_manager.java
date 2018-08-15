package com.java.plyd.spring.dao.academicyear;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.plyd.spring.entity.academicyear;


@Repository("academicyear_dao_manager")
public class academicyear_dao_manager extends SqlMapClientDaoSupport implements
		iacademicyear_dao_manager {

	@Transactional(propagation = Propagation.REQUIRED)

	@Override
	public List<academicyear> selectAll() {
		List<academicyear> academicyearList=null;
		try {
			academicyearList=(List<academicyear>) getSqlMapClientTemplate().queryForList("academicyear.selectAll");
			for (academicyear academicyear2 : academicyearList) {
				System.out.println("DAO-ID"+academicyear2.getid());	
			}
			
		} catch (DataAccessException de) {
			de.printStackTrace();
		}
		return academicyearList;
	}

	@Override
	public academicyear selectByID(int id) {
		academicyear a=null;
		try {
			a=(academicyear) getSqlMapClientTemplate().queryForObject("academicyear.selectByID",id);			
			
		} catch (DataAccessException de) {
			de.printStackTrace();
		}
		return a;
	}

	@Override
	public void insert(academicyear a) {
		// TODO Auto-generated method stub
		try {
			getSqlMapClientTemplate().insert("academicyear.insert",a);			
			
		} catch (DataAccessException de) {
			de.printStackTrace();
		}
		
	}

	@Override
	public void update(academicyear a) {
		// TODO Auto-generated method stub
		try {
			getSqlMapClientTemplate().update("academicyear.update",a);			
			
		} catch (DataAccessException de) {
			de.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			getSqlMapClientTemplate().delete("academicyear.delete",id);			
			
		} catch (DataAccessException de) {
			de.printStackTrace();
		}
	}

}