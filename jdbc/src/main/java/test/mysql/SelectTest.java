package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs =null;
		try {
			// 1. JDBC Driver(My SQL) 로딩 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. 연결하기 
		String url="jdbc:mysql://127.0.0.1:3306/webdb";
			conn =DriverManager.getConnection(url,"webdb","webdb");
		//4. sql문 실행
			stmt=conn.createStatement();
			String sql="select no,name from dept";
			rs= stmt.executeQuery(sql);
		//5. 결과 가져오기 
			while(rs.next()) {
				Long no=rs.getLong(1);
				String name= rs.getString(2);
				System.out.println(no+":"+name);
			}
			
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("드라이버 로딩 실패"+ e);
	}catch(SQLException e) {
		System.out.println("error"+e);
	}finally {
		try {
			if(rs != null)
				rs.close();
			// 3. 자원 정리
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		}catch(SQLException e) {
			
		}
	}
		
		
	}

}
