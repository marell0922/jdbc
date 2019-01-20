package com.douzon.jdbc.hr.test;

import java.sql.SQLException;
import java.util.List;

import com.douzon.jdbc.hr.dao.EmployeeDao;
import com.douzon.jdbc.hr.vo.EmployeeVo;

public class EmployeeDaoTest {
	public static void main(String[] args) {
		connectionTest();
		getListByKeyword("P");
	}
	
	public static void connectionTest() {
		try {
			EmployeeDao.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getListByKeyword(String keyword) {
		List<EmployeeVo> list=new EmployeeDao().getList(keyword);
		
		for(EmployeeVo employeeVo:list) {
			System.out.println(employeeVo);
		}
	}
	
}
