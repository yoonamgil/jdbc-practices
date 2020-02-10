package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public Boolean insert(EmployeeVo vo) {
		return null;
	}
	
	public List<EmployeeVo> findByName(EmployeeVo vo){
		List<EmployeeVo> result = new ArrayList<>();
		
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs =null;
				try {
					// 1. JDBC Driver(My SQL) 로딩 
				Class.forName("com.mysql.jdbc.Driver");
				
				// 2. 연결하기 
				String url="jdbc:mysql://127.0.0.1:3306/employees";
					conn =DriverManager.getConnection(url,"hr","hr");
				
					
					//3. sql문 준비(prepare,완성된 커리가 아님)
					String sql="select emp_no , first_name, last_name, hire_date " + 
							" from employees" + 
							" where first_name like ?" + 
							" order by first_name";
					//4. sql문 실행
					
					pstmt=conn.prepareStatement(sql);
					
					//4. 바인딩 
					pstmt.setString(1,"%"+vo.getFirstName()+"%");
					// 5. 결과 가져오기 
					rs= pstmt.executeQuery();
					
					
				
				//6. 결과 바인딩  
					while(rs.next()) {
						Long no=rs.getLong(1);
						String firstName= rs.getString(2);
						String lastName= rs.getString(3);
						String hireDate=rs.getString(4);
						EmployeeVo evo = new EmployeeVo();
						
						evo.setNo(no);
						evo.setFirstName(firstName);
						evo.setLastName(lastName);
						evo.setHireDate(hireDate);
						
						result.add(evo);
						
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
					if(pstmt!=null)
						pstmt.close();
					if(conn!=null)
						conn.close();
				}catch(SQLException e) {
					
				}
			}
		return result;
	}
}
