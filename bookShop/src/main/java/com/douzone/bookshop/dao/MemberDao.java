package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.MemberVo;

public class MemberDao {
	public List<MemberVo> findAll() {
		
		List<MemberVo> result = new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try {
				
			conn= getConnection();
			String sql="select * from member";
			stmt=conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long no=rs.getLong(1);
				String name= rs.getString(2);
				String phoneNumber= rs.getString(3);
				String mail =rs.getString(4);
				String password= rs.getString(5);
				
				
				MemberVo vo = new MemberVo();
				vo.setName(name);
				vo.setNo(no);
				vo.setPhoneNumber(phoneNumber);
				vo.setMail(mail);
				vo.setPassword(password);
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


	public Boolean insert(MemberVo memberVo) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			
			String sql="insert into member values(null,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, memberVo.getName());
			stmt.setString(2, memberVo.getPhoneNumber());
			stmt.setString(3, memberVo.getMail());
			stmt.setString(4, memberVo.getPassword());

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
