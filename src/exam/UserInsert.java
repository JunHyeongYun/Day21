package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsert {
	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3310/boardtest"; // db 접속 주소 
		String id = "root"; // 아이디 
		String pw = "123456"; // 비밀번호 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		/*
		 * Statment, PreparedStatement 차이 
		 * - Statment는 sql을 한번만 실행함 그러나 PreparedStatement는 반복쿼리가 가능 
		 * - PreparedStatement는 sql injection 에 안전하다 
		 * ㅇㄴㄹㅇㄹㄴㅇㄹㅇㄴ
		 */
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			String sql = " insert into tbl_user(user_id, user_pw) value(?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "erer");
			pstmt.setString(2, "1234567");
			/*
			 * executeUpdate()
			 * - db에 영향을 준 행의 수를 반환 
			 * 즉) 몇개 행이 삽입이 됬고 삭제가 됬고 수정이 되었는지 수를 반환한다 
			 */
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("등록완료되었습니다..");
			}
		} catch (SQLException e) {
			System.out.println("에러..");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver를 로드할 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
