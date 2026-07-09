package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSelect {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mariadb://localhost:3310/boardtest"; // db 접속 주소 
		String id = "root"; // 아이디 
		String pw = "123456"; // 비밀번호 
		
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		// Statement 객체를 생성 Statement 객체를 통해 sql을 실행할 수 있다 
		Statement stmt = conn.createStatement();
		String sql = " select * from tbl_user ";
		
		// SQL을 실행하고 DB 조회 결과를 ResultSet 객체에 담음 
		// ResultSet 
		// 테이블 조회 결과를 자바에서 다룰 수 있게 하는 객체 
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) { // 루프를 돌면서 한행 한행 접근해서 데이터를 가져온다 
			int user_idx = rs.getInt("user_idx");
			String user_id = rs.getString("user_id");
			String user_pw = rs.getString("user_pw");
			
			System.out.println(user_idx + "  " + user_id + "  " + user_pw);
		}
	}
}
