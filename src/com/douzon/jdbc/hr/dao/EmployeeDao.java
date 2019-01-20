package com.douzon.jdbc.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.jdbc.hr.vo.EmployeeVo;

public class EmployeeDao {
	
	public List<EmployeeVo> getList(String keyword){
		List<EmployeeVo> list=new ArrayList<EmployeeVo>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			
			stmt=conn.createStatement();
			
			String sql="select first_name, last_name, email, phone_number, hire_date "
					+ "from employee "
					+ "where first_name like '%"+keyword
					+"%' or last_name like '%"+keyword+"%'";
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				String first_name=rs.getString(1);
				String last_name=rs.getString(2);
				String email=rs.getString(3);
				String phone_number=rs.getString(4);
				String hire_date=rs.getString(5);
				
				EmployeeVo employeeVo=new EmployeeVo();
				employeeVo.setFirst_name(first_name);
				employeeVo.setLast_name(last_name);
				employeeVo.setEmail(email);
				employeeVo.setPhone_number(phone_number);
				employeeVo.setHire_date(hire_date);
				
				list.add(employeeVo);
			}
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/webdb";
			conn=DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("connection fail : "+e);
		}
		
		return conn;
	}
}
