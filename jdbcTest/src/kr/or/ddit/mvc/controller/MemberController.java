package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {
	private IMemberService service;  // Service객체가 저장될 변수 선언
	
	private Scanner scan = new Scanner(System.in);
	
	// 생성자
	public MemberController() {
		//service = new MemberServiceImpl();  // Service객체 생성
		service = MemberServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new MemberController().memberStart();
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
	
	// 회원 정보 수정 - 원하는 항목 수정
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		
		System.out.print("회원ID >> ");
		String id = scan.next();
		
		int count = service.getMemberIdCount(id);
		
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
		
		// 선택한 컬럼명과 수정할 데이터 그리고 회원ID를 Map에 추가한다.
		// key값 정보 : 회원ID(memid), 수정할컬럼명(field), 수정할데이터(data) 
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("memid", id);   	// 회원ID 추가
		paramMap.put("field", field);  	// 수정할 컬럼명 추가
		paramMap.put("data", data);		// 수정할 데이터 추가
		
		int cnt = service.updateMember2(paramMap);
		
		if(cnt>0) {
			System.out.println("수정 작업 성공~~~");
		}else {
			System.out.println("수정 작업 실패!!!");
		}
		
	}
	
	
	// 회원 정보 수정 - 전체 항목 수정
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		
		System.out.print("회원ID >> ");
		String id = scan.next();
		
		int count = service.getMemberIdCount(id);
		
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
		
		// 입력한 자료를 VO객체에 담는다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(id);
		memVo.setMem_pass(newPass);
		memVo.setMem_name(newName);
		memVo.setMem_tel(newTel);
		memVo.setMem_addr(newAddr);
		
		int cnt = service.updateMember(memVo);
		
		if(cnt>0) {
			System.out.println("회원 정보 수정 성공!!!");
		}else {
			System.out.println("회원 정보 수정 실패~~~");
		}
		
	}
	
	
	// 회원 삭제
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("회원ID >> ");
		String id = scan.next();
		
		int cnt = service.deleteMember(id);
		
		if(cnt>0) {
			System.out.println(id + " 회원 정보 삭제 성공!!!");
		}else {
			System.out.println(id + " 회원은 없는 회원이거나 삭제에 실패했습니다...");
		}
		
	}
	
	
	// 전체 회원 목록 출력
	private void displayMember() {
		
		List<MemberVO> memList = service.getAllMember();
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println(" ID    비밀번호     이름     전화번호    주 소");
		System.out.println("-------------------------------------------------");
		if(memList==null || memList.size() == 0) {
			System.out.println(" 등록된 회원이 하나도 없습니다.");
		}else {
			for(MemberVO memVo : memList) {
				String id = memVo.getMem_id();
				String pass = memVo.getMem_pass();
				String name = memVo.getMem_name();
				String tel = memVo.getMem_tel();
				String addr = memVo.getMem_addr();
				
				System.out.println(id + "\t" + pass + "\t" + name + "\t" + tel + "\t" + addr);
			}
		}
		System.out.println("-------------------------------------------------");
		System.out.println("출력 끝...");
	}
	
	
	// 회원 추가
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		
		int count = 0;
		String memId = null;
		do {
			System.out.print("회원ID >> ");
			memId = scan.next();
			
			count = service.getMemberIdCount(memId);
			
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
		
		// 입력한 데이터를 MemberVO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		
		memVo.setMem_id(memId);
		memVo.setMem_pass(pass);
		memVo.setMem_name(name);
		memVo.setMem_tel(tel);
		memVo.setMem_addr(addr);
		
		// Service의 insert메서드 호출
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println(memId + " 회원 정보 추가 완료!!!");
		}else {
			System.out.println(memId + " 회원 정보 추가 실패~~~");
		}
		
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














