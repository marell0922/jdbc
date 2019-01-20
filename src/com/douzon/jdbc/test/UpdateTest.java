package com.douzon.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	public static void main(String[] args) {
		
	}
	public static boolean update(String owner, String gender) {
		      Connection conn = null;
		      PreparedStatement stmt = null;
		      boolean result = false;
		      
		      try {
		         // 1. JDBC Driver(MySQL) 로딩
		         Class.forName("com.mysql.jdbc.Driver"); // pakage이름을 적어서 로딩시킨다. classPath에 db 없으면 에러난다.
		         // 1.1 library (user-library)에 등록하고 적용시켜야지 path가 잡힌다.

		         // 2. 연결하기(Connection 객체 얻어오기) 
		         // jdbc:mysql = http://
		         String url = "jdbc:mysql://localhost:3306/webdb";
		         conn = DriverManager.getConnection(url, "webdb", "webdb");
		         
		      
		         String query = "update pet set gender=?"
		         		+ "where owner=?";
		         
		         stmt = conn.prepareStatement(query);
		         stmt.setString(1, gender);
		         stmt.setString(2, owner);
		         
		         // insert -> executeUpdate(query)
		         int count = stmt.executeUpdate(query);
		         result = count == 1;
		      
		      } catch (ClassNotFoundException e) {
		         System.out.println("드라이버 로딩 실패:" + e);
		      } catch (SQLException e) {
		         System.out.println("sqlerror:" + e);
		      } finally {
		         try {
		            // 처음 실패시 null을 가르키기때문에 또 에러가 나온다.
		            if(stmt != null)
		               stmt.close();
		            if (conn != null)
		               conn.close();
		         } catch (SQLException e) {
		            e.printStackTrace();
		         }

		      }

		      return result;
		   }
	}

