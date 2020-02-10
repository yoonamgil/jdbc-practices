package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.BookVo;

public class BookDao {

public List<BookVo> findAll() {
		
		List<BookVo> result = new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try {
				
			conn= getConnection();
			String sql="select a.* ,b.category from book a, category b " + 
					"where a.category_No=b.no";
			stmt=conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long no=rs.getLong(1);
				String title= rs.getString(2);
				Long price= rs.getLong(3);
				Long categoryNo =rs.getLong(4);
				
				String categoryName= rs.getString(5);
				
				
				BookVo vo = new BookVo();
				vo.setTitle(title);
				vo.setNo(no);
				vo.setPrice(price);
				vo.setCategoryNo(categoryNo);
				
				vo.setCategoryName(categoryName);
				
				System.out.println(vo);
			}
				
		} catch(SQLException e) {
			System.out.println("error"+e);
		}finally {
			try {
				
				// 3. 자원 정리
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}catch(SQLException e) {	
			}
		}
			return result;
	}


	public Boolean insert(BookVo bookVo) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			
			String sql="insert into book values(null,?,?,(select no from " + 
					"category where category=?));";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, bookVo.getTitle());
			stmt.setLong(2, bookVo.getPrice());
			stmt.setString(3, bookVo.getCategoryName());

			int count=stmt.executeUpdate();
			result = count ==1;	
			
		}catch(SQLException e) {
			System.out.println("error"+e);
		}finally {
			try {
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			}catch(SQLException e) {	
			}
		}
			return result ;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn=null;
		try {
			// 1. JDBC Driver(My SQL) 로딩 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. 연결하기 
		String url="jdbc:mysql://127.0.0.1:3306/bookshop";
			conn =DriverManager.getConnection(url,"bookshop","bookshop");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패"+ e);
		}
		
		return conn;
		
	}		
	
}
