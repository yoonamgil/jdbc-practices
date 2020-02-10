package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;


public class BookDao {
	public List<BookVo> findAll() {
		
		List<BookVo> result = new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try {
				
			conn= getConnection();
			String sql="select b.no,b.title,b.state,b.author_no,a.name from author a, book b " + 
					"where a.no=b.author_no";
			stmt=conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long no=rs.getLong(1);
				String title= rs.getString(2);
				String state = rs.getString(3);
				long authorNO=rs.getLong(4);
				String authorName= rs.getString(5);
				
					
				BookVo vo = new BookVo();
				vo.setTitle(title);
				vo.setNo(no);
				vo.setState(state);
				vo.setAuthorNO(authorNO);
				vo.setAuthorName(authorName);
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
	
	public boolean delete(BookVo bookVo) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			
			String sql="delete from book where title=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, bookVo.getTitle());
			
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
	public Boolean update(BookVo bookVo,String reName) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			String sql="update book set title=? where title=? ";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, reName);
			stmt.setString(2, bookVo.getTitle());
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
	public Boolean update(BookVo bookVo) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			
			String sql="update book set state=? where title=?; ";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, "대여중");
			stmt.setString(2, bookVo.getTitle());
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
	
	public Boolean insert(BookVo bookVo,String author) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			
			String sql="insert into book value(null,?,'대여가능'," + 
					"(select no from author where name=? ));";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, bookVo.getTitle());
			stmt.setString(2, author);
			
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
		String url="jdbc:mysql://127.0.0.1:3306/webdb";
			conn =DriverManager.getConnection(url,"webdb","webdb");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패"+ e);
		}
		
		return conn;
		
	}	
}
