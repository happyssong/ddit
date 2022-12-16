package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// static 초기화 블럭
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패~~~");
			e.printStackTrace();
		}
	}
	
	// DB에 접속하고 접속이 성공하면 Connection객체를 반환하는 메서드
	// 	접속에 실패하면 null 반환
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "ddit", "java");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패~~~");
			return null;
		}
	}
}









