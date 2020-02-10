package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrdersVo;

public class OrdersDao {

public List<OrdersVo> findAll() {
		
		List<OrdersVo> result = new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try {
				
			conn= getConnection();
			String sql="select b.name,b.mail,a.* from orders a, member b  " + 
					"where b.no=a.member_no;";
			stmt=conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				String memberName= rs.getString(1);
				String memberMail= rs.getString(2);
				Long no=rs.getLong(3);
				Long price= rs.getLong(4);
				String address= rs.getString(5);
				String orderNo =rs.getString(6);
				Long memberNo= rs.getLong(7);
				
				OrdersVo vo = new OrdersVo();
				vo.setPrice(price);
				vo.setNo(no);
				vo.setAddress(address);
				vo.setOrderNo(orderNo);
				vo.setMemberNo(memberNo);
				vo.setMemberName(memberName);
				vo.setMemberMail(memberMail);
				System.out.println(vo);
				findAll(no);
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
	public List<OrderBookVo> findAll(Long ordersNo) {
		
		List<OrderBookVo> result = new ArrayList<>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try {
				
			conn= getConnection();
			String sql="select a.book_no,c.title,a.amount " + 
					"from order_book a, orders b, book c " + 
					"where a.order_no=b.no " + 
					"and   a.book_no=c.no  " + 
					"and   a.order_no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setLong(1,ordersNo);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Long no=rs.getLong(1);
				String title= rs.getString(2);
				Long amount= rs.getLong(3);
				
				
				
				OrderBookVo vo = new OrderBookVo();
				vo.setBookNo(no);
				vo.setBookName(title);
				vo.setAmount(amount);
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

	public Boolean insert(OrdersVo ordersVo) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn= getConnection();
			
			String sql="insert into orders values(null,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setLong(1, ordersVo.getPrice());
			stmt.setString(2, ordersVo.getAddress());
			stmt.setString(3, ordersVo.getOrderNo());
			stmt.setLong(4, ordersVo.getMemberNo());

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
	public Boolean insert(OrderBookVo orderBookVo) {
		Boolean result=	null;
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn= getConnection();
			
			String sql="insert into order_book values(?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setLong(1, orderBookVo.getBookNo());
			stmt.setLong(2, orderBookVo.getOrderNo());
			stmt.setLong(3, orderBookVo.getAmount());
			

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
