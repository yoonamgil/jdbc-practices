package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.AuthorVo;


public class AuthorDao {
	
	
	public List<AuthorVo> findAll() {
			
		List<AuthorVo> result = new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try {
				
			conn= getConnection();
			String sql="select * from author";
			stmt=conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long no=rs.getLong(1);
				String name= rs.getString(2);
					
				AuthorVo vo = new AuthorVo();
				vo.setName(name);
				vo.setNo(no);
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
	
	public boolean delete(AuthorVo authorVo) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			
			String sql="delete from author where name=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, authorVo.getName());
			
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
	public Boolean update(AuthorVo authorVo,String reName) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			
			String sql="update author set name=? where name=? ";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, reName);
			stmt.setString(2, authorVo.getName());
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
	public Boolean insert(AuthorVo authorVo) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			
			String sql="insert into author values(null,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, authorVo.getName());
			
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
