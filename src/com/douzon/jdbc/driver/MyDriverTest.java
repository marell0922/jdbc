package com.douzon.jdbc.driver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class MyDriverTest implements Driver {
	
	static {
		System.out.println("static coid area");
		try {
			DriverManager.registerDriver(new MyDriverTest());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // class loading
	
	
	public static void main(String[] args) {
		Connection conn=null;
		//1.JDBC Driver(MySQL) �ε�
		try {
			Class.forName("com.douzon.jdbc.driver.MyDriverTest");
			
			//2.�����ϱ�
			String url="jdbc:mysql://localhost:3306/webdb";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver loading fail : " + e);
		}catch(SQLException e) {
			System.out.println("error : "+ e);
		}finally {
			
				try {
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}


	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(url);
		System.out.println(info);
		return new MyConnection();
	}


	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
}
