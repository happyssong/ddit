package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
	LPROD테이블에 새로운 데이터를 추가하기
	
	- lprod_gu와 lprod_nm은 직접 입력 받아서 처리하고,
	  lprod_id는 현재의 lprod_id 중 제일 큰 값보다 1 크게해서 처리한다.
	- 그리고 입력받은 lprod_gu가 이미 등록되어 있는 데이터면 다시 입력 받아서 처리한다.
*/
public class JdbcTest05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe", "ddit", "java");
			
			conn = DBUtil.getConnection();
			
			// lprod_id는 현재의 lprod_id 중 제일 큰 값보다 1 크게해서 처리한다.
			String sql = "select max(lprod_id) maxnum from lprod ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int maxNum = 0;
			if(rs.next()) {
				//maxNum = rs.getInt(1);
				//maxNum = rs.getInt("max(lprod_id)");  // alias를 지정하지 않았을 때
				maxNum = rs.getInt("maxnum"); // alias를 지정했을 때
			}
			maxNum++;   // 제일 큰 값보다 1 크게...
			
			// 입력받은 lprod_gu가 이미 등록되어 있는 데이터면 다시 입력 받아서 처리한다.
			String lgu;		// 상품분류코드가 저장될 변수 선언
			int count = 0; 	// 입력한 상품분류코드의 개수가 저장될 변수 선언
			
			String sql2 = "select count(*) cnt from lprod "
					+ " where lprod_gu = ?";
			pstmt = conn.prepareStatement(sql2);
			
			do {
				System.out.print("Lprod_gu값 입력 : ");
				lgu = scan.next();
				
				pstmt.setString(1, lgu);
				
				rs = pstmt.executeQuery();  // select문일 경우
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				if(count>0) {
					System.out.println("입력한 Lprod_gu값은 이미 등록된 값 입니다.");
					System.out.println("다시 입력하세요.");
				}
				
			}while(count>0);
			
			System.out.println();
			System.out.print("Lprod_nm값 입력 : ");
			String lnm = scan.next();
			
			String sql3 = "insert into lprod (lprod_id, lprod_gu, lprod_nm) "
					+ " values (?, ?, ?) ";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, maxNum);
			pstmt.setString(2, lgu);
			pstmt.setString(3, lnm);
			
			int cnt = pstmt.executeUpdate();  // select문이 아닐 때...
			
			if(cnt>0) {
				System.out.println("insert 작업 성공!!!");
			}else {
				System.out.println("insert 작업 실패~~~");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}

	}

}











