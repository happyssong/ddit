package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC(Java DataBase Connectivity)라이브러리를 이용한 DB자료 처리하기
public class JdbcTest01 {
/*	
	- JDBC를 이용한 DB자료 처리 순서
1. 드라이버 로딩 ==> 라이브러리를 사용할 수 있게 메모리에 라이브러리를 읽어들이는 작업
	==> JDBC버전 4이상에서는 getConnection()메서드에서 자동으로 로딩을 해주기 
		때문에 생략할 수 있다. (하지만, 생략하지 않고 사용할 예정)
  Class.forName("oracle.jdbc.driver.OracleDriver");

2. DB에 접속하기 ==> 접속이 완료되면 Connection객체가 반환된다.
  DriverManager.getConnection()메서드를 이용한다.
    
3. 처리할 쿼리문을 문자열로 작성한다.

4. 질의 ==> 작성한 쿼리문을 DB서버에 보내서 결과를 얻어온다.
 	(Statement객체 또는 PreparedStatement객체를 이용하여 작업한다.)

5. 결과 처리하기 ==> 질의 결과를 받아서 원하는 작업을 수행한다.
  1) 쿼리문이 'select문'일 경우 select한 결과가 ResultSet객체에 저장되어 반환된다.
  
  2) 쿼리문이 'select문'이 아닐경우(insert, update, delete ...)
     결과로 정수값이 반환된다. (정수값은 실행에 성공한 레코드 수를 말한다.)

6. 사용한 자원 반납하기 ==> 각 객체의 close()메서드를 이용한다.
	
	192.168.143.14
	
	
*/
	public static void main(String[] args) {
		// DB작업에 필요한 객체 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB연결 ==> Connection객체 생성
			conn = DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe", 
				"jdbc:oracle:thin:@192.168.143.14:1521:xe", 
				"ddit", "java");
			
			// 3. 쿼리문 작성
			String sql = "select * from lprod";
			
			// 4. 질의 
			// 4-1. Statement객체 또는 PreparedStatement객체 생성
			stmt = conn.createStatement();  // Statement객체 생성하기
			
			// 4-2. 쿼리문을 DB서버로 보내서 결과를 얻어온다.
			//		( 실행할 쿼리문이 select문이기 때문에 결과가 
			//		  ResultSet객체에 저장되어 반환된다. )
			rs = stmt.executeQuery(sql);
			
			// 5. 결과 처리하기
			// 	==> select한 결과를 한 레코드씩 화면에 출력하기
			//		(반복문과 next()메서드를 이용해서 처리한다.)
			System.out.println("=== 쿼리문 처리 결과 ===");
			
			// rs.next() ==> ResultSet객체의 데이터를 가리키는 포인터를
			//			다음번째 레코드 위치로 이동시키고 그 곳에 데이터가 있으면
			//			true, 없으면 false를 반환한다.
			while(rs.next()) {
				// 포인터가 가리키는 곳의 자료를 가져오는 방법
				// 형식1) rs.get자료형이름("컬럼명" 또는 "alias명");
				//		==> '컬럼명'과 'alias명'은 대소문자 구분없이 사용 가능
				// 형식2) rs.get자료형이름(컬럼번호); ==> 컬럼번호는 1부터 시작
				System.out.println("Lprod_id : " + rs.getInt("lprod_id"));   
				System.out.println("Lprod_gu : " + rs.getString(2));
				System.out.println("Lprod_nm : " + rs.getString("LPROD_NM"));
				System.out.println("---------------------------------");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 반납...
			if(rs!=null) try { rs.close(); }catch(SQLException e) {}
			if(stmt!=null) try { stmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		

	}

}













