package com.douzon.jdbc.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.jdbc.bookshop.vo.BookVo;

public class BookDao {
	
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
	
	public List<BookVo> getList(){
		List<BookVo> list=new ArrayList<BookVo>();
		
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs=null;
	      try {
	    	  
	         conn = getConnection();
	         
	         stmt = conn.createStatement();
	         
	         String sql="select a.no, a.title, a.status, b.no, b.name "
	         		+ "from book a, author b "
	         		+ "where a.author_no=b.no "
	         		+ "order by a.no";
		         
	         rs=stmt.executeQuery(sql);
	         
	         while(rs.next()) {
	        	 long no=rs.getLong(1);
	        	 String title=rs.getString(2);
	        	 String status=rs.getString(3);
	        	 long authorNo=rs.getLong(4);
	        	 String authorName=rs.getString(5);
	        	 
	        	 BookVo bookVo=new BookVo();
	        	 bookVo.setNo(no);
	        	 bookVo.setTitle(title);
	        	 bookVo.setStatus(status);
	        	 bookVo.setAuthorNo(authorNo);
	        	 bookVo.setAuthorName(authorName);
	        	 
	        	 list.add(bookVo);
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
	
	public BookVo getBookVo(long book_no) {
		BookVo bookVo=null;
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs=null;
	      try {
	    	  
	         conn = getConnection();
	         
	         stmt = conn.createStatement();
	         
	         String sql="select a.no, a.title, a.status, b.no, b.name "
	         		+ "from book a, author b "
	         		+ "where a.author_no=b.no "
	         		+ "and a.no="+book_no
	         		+ " order by a.no";
		         
	         rs=stmt.executeQuery(sql);
	         
	         while(rs.next()) {
	        	 bookVo=new BookVo();
	        	 long no=rs.getLong(1);
	        	 String title=rs.getString(2);
	        	 String status=rs.getString(3);
	        	 long authorNo=rs.getLong(4);
	        	 String authorName=rs.getString(5);
	        	 
	        	 
	        	 bookVo.setNo(no);
	        	 bookVo.setTitle(title);
	        	 bookVo.setStatus(status);
	        	 bookVo.setAuthorNo(authorNo);
	        	 bookVo.setAuthorName(authorName);
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
		
		
		
		return bookVo;
	}
	
	public boolean updateStatus(long no, String status) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="update book "
					+ "set status = ? "
					+"where no= ? ";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.setLong(2, no);
			
			int count=stmt.executeUpdate();
			result=count==1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean insert(BookVo bookVo) {
		boolean result =false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="insert into book "
					+ "values (null ,?, '대여가능', ?)";
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, bookVo.getTitle());
			stmt.setLong(2, bookVo.getAuthorNo());
			
			int count=stmt.executeUpdate();
			result=count==1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public boolean update(BookVo bookVo) {
		// 책정보 수정
		boolean result=false;
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=getConnection();
			
			String sql="update book "
					+ "set title=?, "
					+ "authorName=? "
					+ "where no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, bookVo.getTitle());
			stmt.setString(2, bookVo.getAuthorName());
			stmt.setLong(3, bookVo.getNo());
			
			int count=stmt.executeUpdate();
			result=count==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}	

}
