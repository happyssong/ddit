package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) lprod_id값을 2개 입력 받아서 두 값 중 작은값부터 큰값 사이의
//		자료들을 출력하시오.

public class JdbcTest03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 Lprod_id값 입력 : ");
		int num1 = scan.nextInt();
		
		System.out.print("두번째 Lprod_id값 입력 : ");
		int num2 = scan.nextInt();
		
		// 큰 값과 작은 값 찾기
		int max, min;
		max = num1 > num2 ? num1 : num2;
		min = num1 > num2 ? num2 : num1;
		
		// DB관련 객체 변수 선언
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.143.14", "ddit", "java");
			/*
			String sql = "select * from lprod "
				+ "where lprod_id >=" + min + " and lprod_id <=" + max;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			*/
			
//			String sql = "select * from lprod "
//					+ "where lprod_id >= ? and lprod_id <= ? ";
			String sql = "select * from lprod "
					+ "where lprod_id between ? and ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			
			rs = pstmt.executeQuery();
			
			
			
			System.out.println();
			System.out.println(" == 결과 출력 ==");
			while(rs.next()) {
				System.out.println("ID : " + rs.getInt("lprod_id"));
				System.out.println("GU : " + rs.getString("lprod_gu"));
				System.out.println("NM : " + rs.getString("lprod_nm"));
				System.out.println("--------------------------------");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
			if(stmt!=null) try { stmt.close(); } catch(SQLException e) {}
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		
		
		
		

	}

}














