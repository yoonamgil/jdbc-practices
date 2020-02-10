package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CartVo;

public class CartDao {
public List<CartVo> findAll() {
		
		List<CartVo> result = new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try {
				
			conn= getConnection();
			String sql="select a.*,b.title,b.price from cart a, book b, member c "
					+ " where a.book_no=b.no and a.member_no=c.no";
			stmt=conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long bookNo=rs.getLong(1);
				Long memberNo=rs.getLong(2);
				Long amount=rs.getLong(3);
				String bookName=rs.getString(4);
				Long price= rs.getLong(5);
				

				CartVo vo = new CartVo();
				vo.setBookNo(bookNo);
				vo.setMemberNo(memberNo);
				vo.setAmount(amount);
				vo.setBookName(bookName);
				vo.setPrice(price);
				
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


	public Boolean insert(CartVo cartVo) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn= getConnection();
			
			String sql="insert into cart values(?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setLong(1, cartVo.getBookNo());
			stmt.setLong(2, cartVo.getMemberNo());
			stmt.setLong(3, cartVo.getAmount());

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
