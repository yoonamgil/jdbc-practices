package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDriverTest {

	public static void main(String[] args) {
	
		
		try {
				//1. jdbc 드라이버  로딩 
			Class.forName("driver.MyDriver");
			
			// 2. 연결하기 
			String url="jdbc:mysql://127.0.0.1:3306/webdb";
			Connection connection =DriverManager.getConnection(url,"webdb","webdb");
			System.out.println(connection);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패"+ e);
		}catch(SQLException e) {
			System.out.println("error"+e);
		}
		
		

	}

}
