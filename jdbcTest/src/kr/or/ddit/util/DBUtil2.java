package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


// dbinfo.properties파일의 내용을 이용하여 셋팅하는 방법  

// 방법1) Properties객체 이용하기
public class DBUtil2 {
	static Properties prop;		// Properties객체 변수 선언
	
	// static 초기화 블럭
	static {
		prop = new Properties();  // Properties객체 생성
		
		File f = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(f);  // 입력 스트림 객체 생성
			
			prop.load(fin);  // 파일 읽어서 Properties객체에 추가하기
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
		} catch (IOException e) {
			System.out.println("입출력 오류...");
			System.out.println("드라이버 로딩 실패~~~");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패~~~");
			e.printStackTrace();
		} finally {
			if(fin!=null) try { fin.close(); }catch(IOException e) {}
		}
	}
	
	// DB에 접속하고 접속이 성공하면 Connection객체를 반환하는 메서드
	// 	접속에 실패하면 null 반환
	public static Connection getConnection() {
		try {
//			return DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe", "ddit", "java");
			
			return DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("user"), 
					prop.getProperty("pass"));
			
		} catch (SQLException e) {
			System.out.println("DB 연결 실패~~~");
			return null;
		}
	}
}









