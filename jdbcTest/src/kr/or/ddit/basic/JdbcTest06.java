package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

/*
	회원을 관리하는 프로그램을 작성하시오. ( MYMEMBER테이블 이용 )
	
	- 아래 메뉴의 기능을 모두 구현하시오. (CRUD기능 구현하기)
	메뉴예시)
		1. 자료 추가			--> insert (C)
		2. 자료 삭제			--> delete (D)
		3. 자료 수정			--> update (U)
		4. 전체 자료 출력		--> select (R)
		0. 작업 끝.
	
	- 조건
	1) 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력 받는다.)
	2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
	3) 자료 수정에서 '회원ID'는 변경되지 않는다.
	
	
	- MVC패턴, Singleton패턴

*/
public class JdbcTest06 {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new JdbcTest06().memberStart();
	}
	
	// 자원을 반납하는 메서드
	private void disConnect() {
		if(rs!=null) try {rs.close(); }catch(SQLException e) {}
		if(stmt!=null) try {stmt.close(); }catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close(); }catch(SQLException e) {}
		if(conn!=null) try {conn.close(); }catch(SQLException e) {}
	}
	
	// 시작 메서드
	public void memberStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1 :		// 추가
				insertMember(); break;
			case 2 :		// 삭제
				deleteMember(); break;
			case 3 :		// 수정
				updateMember(); break;
			case 4 :		// 전체 출력
				displayMember(); break;
			case 5 :		// 수정
				updateMember2(); break;
			case 0 :
				System.out.println("프로그램을 종료합니다...");
				return;
			default :
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
			}
		}
	}
	
	// 회원 정보를 수정하는 메서드 ==> 원하는 항목만 수정하기
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		
		System.out.print("회원ID >> ");
		String id = scan.next();
		
		int count = getMemberIdCount(id);
		
		if(count==0) {  // 없는 회원이면...
			System.out.println(id + "은(는) 없은 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}
		
		int num;
		String field = null;  // 수정할 항목의 컬럼명이 저장될 변수
		String title = null;  // 수정할 항목을 입력 받을 때 사용할 메시지(항목명)
		
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요...");
			System.out.println(" 1. 비밀번호   2. 회원이름   3. 전화번호   4. 회원주소");
			System.out.println("----------------------------------------------");
			System.out.print("수정할 항목 선택 >> ");
			num = scan.nextInt();
			
			switch(num) {
				case 1 :	// 비밀번호
					field = "mem_pass"; 	title = "비밀번호";
					break;
				case 2 :  	// 회원이름
					field = "mem_name"; 	title = "회원이름";
					break;
				case 3 :  	// 전화번호
					field = "mem_tel"; 		title = "전화번호";
					break;
				case 4 :  	// 회원주소
					field = "mem_addr"; 	title = "회원주소";
					break;
				default :
					System.out.println(" 수정할 항목 번호를 잘못 입력했습니다.");
					System.out.println(" 다시 선택하세요.");
			}
			
		}while(num<1 || num>4);
		
		System.out.println();
		
		scan.nextLine(); 	// 입력 버퍼 비우기
		System.out.print("새로운 " + title + " >> ");
		String data = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set " + field + " = ? where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data);
			pstmt.setString(2, id);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("수정 작업 성공!!!");
			}else {
				System.out.println("수정 작업 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		
	}
	
	
	
	// 회원 정보를 수정하는 메서드 ==> 전체 항목 수정하기
	// 자료 수정에서 '회원ID'는 변경되지 않는다.
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		
		System.out.print("회원ID >> ");
		String id = scan.next();
		
		int count = getMemberIdCount(id);
		
		if(count==0) {  // 없는 회원이면...
			System.out.println(id + "은(는) 없은 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}
		
		System.out.println();
		System.out.print("새로운 비밀번호 >> ");
		String newPass = scan.next();
		
		System.out.print("새로운 회원이름 >> ");
		String newName = scan.next();
		
		System.out.print("새로운 전화번호 >> ");
		String newTel = scan.next();
		
		scan.nextLine();  // 입력 버퍼 비우기
		System.out.print("새로운 회원주소 >> ");
		String newAddr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set "
					+ " mem_pass = ? , mem_name = ? ,"
					+ " mem_tel = ? , mem_addr = ? "
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, newName);
			pstmt.setString(3, newTel);
			pstmt.setString(4, newAddr);
			pstmt.setString(5, id);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(id + " 회원 정보 수정 완료!!!");
			}else {
				System.out.println(id + " 회원 정보 수정 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		
		
		
		
	}
	
	
	// 회원 정보를 삭제하는 메서드
	// 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("회원ID >> ");
		String id = scan.next();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "delete from mymember where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(id + " 회원 정보 삭제 성공!!!");
			}else {
				System.out.println(id + " 회원은 없는 회원이거나 삭제에 실패했습니다...");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}
	
	
	// 전체 회원 정보를 출력하는 메서드
	private void displayMember() {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println(" ID    비밀번호     이름     전화번호    주 소");
		System.out.println("-------------------------------------------------");
		
		try {
//			conn = DBUtil.getConnection();
//			conn = DBUtil2.getConnection();
			conn = DBUtil3.getConnection();
			
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("mem_id");
				String pass = rs.getString("mem_pass");
				String name = rs.getString("mem_name");
				String tel = rs.getString("mem_tel");
				String addr = rs.getString("mem_addr");
				
				System.out.println(id + "\t" + pass + "\t" + name + "\t"
						+ tel + "\t" + addr);
			}
			System.out.println("-------------------------------------------------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}
	
	
	// 회원 정보를 추가하는 메서드
	// 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력 받는다.)
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		
		int count = 0;
		String memId = null;
		do {
			System.out.print("회원ID >> ");
			memId = scan.next();
			
			count = getMemberIdCount(memId);
			
			if(count>0) {
				System.out.println(memId + "은(는) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
			
		}while(count>0);
		
		System.out.print("비밀번호 >> ");
		String pass = scan.next();
		
		System.out.print("회원이름 >> ");
		String name = scan.next();
		
		System.out.print("전화번호 >> ");
		String tel = scan.next();
		
		scan.nextLine(); // 입력버퍼 비우기
		System.out.print("회원주소 >> ");
		String addr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "insert into mymember "
					+ "(mem_id, mem_pass, mem_name, mem_tel, mem_addr ) "
					+ " values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(memId + " 회원 정보 추가 완료!!!");
			}else {
				System.out.println(memId + " 회원 정보 추가 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	} // insertMember메서드 끝...
	
	
	
	// 회원ID를 인수값으로 받아서 해당 회원ID의 개수를 반환하는 메서드
	private int getMemberIdCount(String memId) {
		int count = 0;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select count(*) cnt from mymember "
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return count;
		
	}
	
	
	
	
	
	// 메뉴를 출력하고 작업 번호을 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("------------------");
		System.out.println("  1. 자 료 추 가");
		System.out.println("  2. 자 료 삭 제");
		System.out.println("  3. 자 료 수 정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 자 료 수 정 2");
		System.out.println("  0. 작 업 끝.");
		System.out.println("------------------");
		System.out.print(" 원하는 작업 선택 >> ");
		return scan.nextInt();
	}
	
	
	
	
	

}


















