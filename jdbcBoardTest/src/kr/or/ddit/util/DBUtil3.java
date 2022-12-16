package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// dbinfo.properties파일의 내용을 이용하여 셋팅하는 방법  

// 방법2) ResourceBundle객체 이용하기

public class DBUtil3 {
	static ResourceBundle bundle; 	// ResourceBundle객체 변수 선언
	
	// static 초기화 블럭
	static {
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");  // 객체 생성
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패~~~");
			e.printStackTrace();
		}
	}
	
	// DB에 접속하고 접속이 성공하면 Connection객체를 반환하는 메서드
	// 	접속에 실패하면 null 반환
	public static Connection getConnection() {
		try {
//			return DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe", "ddit", "java");
			return DriverManager.getConnection(
					bundle.getString("url"), 
					bundle.getString("user"), 
					bundle.getString("pass"));
			
		} catch (SQLException e) {
			System.out.println("DB 연결 실패~~~");
			return null;
		}
	}
}









