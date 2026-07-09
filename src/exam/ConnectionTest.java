package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		/*
		 * DB Connection
		 */
		String url = "jdbc:mariadb://localhost:3310/boardtest"; // db 접속 주소 
		String id = "root"; // 아이디 
		String pw = "123456"; // 비밀번호 
		
		Connection conn = null; 
		
		try {
			// 드라이버 불러오기 
			Class.forName("org.mariadb.jdbc.Driver");
			// 드라이버로 서버에 접속할 수 있는 커넥션 객체를 가져온다 
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("연결성공 .....");
		} catch (SQLException e) {
			System.out.println("연결실패...");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
		/*
		 * 데이터베이스(DB)
		 * - 데이터베이스는 데이터의 집합이라고 한다 
		 * 데이터베이스에는 대부분의 정보가 저장되고 관리된다 
		 * 
		 * JDBC
		 * - JDBC는 자바에서 데이터베이스에 접속할 수 있도록 하는 자바  API
		 * 
		 * DBMS
		 * - 데이터베이스를 관리하고 운영하는 소프트웨어 
		 * 
		 * DBMS의 종류
		 * - DBMS의 유형은 계층형, 망형, 관계형 등이 있다 
		 * - 일반적으로 생각하는 데이터베이스는 대부분 관계형(RDBMS)을 떠올림 
		 * - 관계형 데이터베이스의 종류로는 ORACLE, Mysql, MariaDB, MS-SQL 등...
		 * 
		 * 관계형 데이터베이스(RDBMS)
		 * - 테이블이라는 최소 단위로 구성되며, 이 테이블은 하나 이상의 열과 행으로 
		 * 이뤄져 있고 모든 데이터가 여기에 저장된다 
		 * 
		 * 
		 */
	}
}
