package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		DeptVo vo = new DeptVo();
		vo.setNo(5L);
		vo.setName("기획운영팀");
		
		Boolean result = update(vo);

	}
	public static Boolean update(DeptVo Vo) {
		Boolean result=	null;
		
		
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			// 1. JDBC Driver(My SQL) 로딩 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. 연결하기 
		String url="jdbc:mysql://127.0.0.1:3306/webdb";
			conn =DriverManager.getConnection(url,"webdb","webdb");
		//4. sql문 실행
			stmt=conn.createStatement();
			String sql="update dept set name ='"+Vo.getName()+ "' where no ="+Vo.getNo();
			
		//5. 성공여부 
			int count=stmt.executeUpdate(sql);
			//5. 성공여부 
				result = count ==1;
			
			
			
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("드라이버 로딩 실패"+ e);
	}catch(SQLException e) {
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
		
		return result ;
	}
}
