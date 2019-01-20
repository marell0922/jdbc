package com.douzon.jdbc.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.jdbc.bookshop.vo.AuthorVo;

public class AuthorDao {
	public boolean insert(AuthorVo authorVo) {
		boolean result=false;
		
		Connection conn = null;
	    PreparedStatement stmt = null;
	      
	      try {
	         conn = getConnection();
	         
	         //3. Statement 객체를 생성
	         String sql="insert into author " + 
	         		"values (null, ?, ?);";
	         stmt = conn.prepareStatement(sql);

	         stmt.setString(1, authorVo.getName());
	         stmt.setString(2, authorVo.getBio());
	         
	         int count = stmt.executeUpdate();
	         result = count == 1;
	      
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
	
	public List<AuthorVo> getList(){
		List<AuthorVo> list=new ArrayList<AuthorVo>();
		
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs=null;
	      try {
	    	  
	         conn = getConnection();
	         
	         stmt = conn.createStatement();
	         
	         String sql="select no, name, bio from author;";
		         
	         rs=stmt.executeQuery(sql);
	         
	         while(rs.next()) {
	        	 long no=rs.getLong(1);
	        	 String name=rs.getString(2);
	        	 String bio=rs.getString(3);
	        	 
	        	 AuthorVo authorVo=new AuthorVo();
	        	 authorVo.setNo(no);
	        	 authorVo.setName(name);
	        	 authorVo.setBio(bio);
	        	 
	        	 list.add(authorVo);
	         }
	      
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
		
		
		
		return list;
		
	}

	public AuthorVo getDate(long author_no) {
		AuthorVo authorVo=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			
			stmt=conn.createStatement();
			String sql="select no,name, bio from author "
					+ "where no="+author_no;
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				authorVo=new AuthorVo();
				long no=rs.getLong(1);
				String name=rs.getString(2);
				String bio=rs.getString(3);
				
				authorVo.setNo(no);
				authorVo.setName(name);
				authorVo.setBio(bio);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authorVo;
	}
	
	/*public boolean update(AuthorVo authorVo) {
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="update author"
					+ "set name=?, bio=?"
					+ "where no=?";
			
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, authorVo.getName());
			stmt.setString(2, authorVo.getBio());
			stmt.setLong(3, authorVo.getNo());
			
			int count=stmt.executeUpdate();
			result=count==1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean delete(long no) {
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="delete from author "
					+ "where no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setLong(1, no);
			int count = stmt.executeUpdate();
			result=count==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	*/
	private static Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/webdb";
			conn=DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
