package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.IJdbcBoardService;
import kr.or.ddit.board.service.JdbcBoardServiceImpl;
import kr.or.ddit.board.vo.JdbcBoardVO;

public class JdbcBoardController {
	private IJdbcBoardService service;
	private Scanner scan;
	
	public JdbcBoardController() {
		service = JdbcBoardServiceImpl.getInstance();
		scan = new Scanner(System.in);
	}
	

	public static void main(String[] args) {
		new JdbcBoardController().boardStart();
	}
	
	// 시작 메서드
	public void boardStart() {
		String title = null;
		int choice = 0;
		
		while(true) {
			
			if(choice!=3) {
				title = null;
			}
			
			choice = displayMenu(title);
			
			switch(choice) {
				case 1 :	// 새글작성
					insert(); break;
				case 2 :	// 게시글보기
					viewBoard(); break;
				case 3 :	// 검색
					title = search(); break;
				case 0 :	// 작업끝.
					System.out.println("게시판 프로그램 종료...");
					return;
				default : 
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요.");
			}
		}
	}
	
	// 게시글을 검색하는 메서드 ==> 검색할 단어를 입력받아 반환하는 메서드
	private String search() {
		System.out.println();
		scan.nextLine();  // 입력버퍼 비우기
		
		System.out.println("검색 작업");
		System.out.println("--------------------------------------------");
		System.out.print("- 검색할 제목 입력 : ");
		
		return scan.nextLine();
	}
	
	
	// 게시글 내용을 보여주는 메서드
	private void viewBoard() {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력 >> ");
		int boardNo = scan.nextInt();
		
		JdbcBoardVO boardVo = service.getBoard(boardNo);
		
		if(boardVo==null) {
			System.out.println(boardNo + " 번의 게시글은 존재하지 않습니다.");
			return;
		}
		
		System.out.println();
		System.out.println(boardNo + " 번글 내용");
		System.out.println("------------------------------------------------------------"); 
		System.out.println("- 제  목 : " + boardVo.getBoard_title());      
		System.out.println("- 작성자 : " + boardVo.getBoard_writer());           
		System.out.println("- 내  용 : " + boardVo.getBoard_content());  
		System.out.println("- 작성일 : " + boardVo.getBoard_date());
		System.out.println("- 조회수 : " + boardVo.getBoard_cnt());
		System.out.println("------------------------------------------------------------"); 
		System.out.println(" 메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		System.out.print("작업선택 >> "); 
		
		int num = scan.nextInt();
		switch(num) {
			case 1 :	// 수정
				update(boardNo); break;
			case 2 :	// 삭제
				delete(boardNo); break;
			case 3 :	// 리스트로가기
				return;
		}
		
	}
	
	// 게시글을 삭제하는 메서드
	private void delete(int boardNo) {
		int cnt = service.deleteBoard(boardNo);
		
		if(cnt>0) {
			System.out.println(boardNo + " 번글의 게시글이 삭제되었습니다.");
		}else {
			System.out.println(boardNo + " 번글 삭제작업 실패!!!");
		}
		
	}
	
	
	// 게시글을 수정하는 메서드
	private void update(int boardNo) {
		System.out.println();
		
		scan.nextLine(); // 입력 버퍼 비우기
		
		System.out.println("수정 작업하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제 목 : ");
		String title = scan.nextLine();
		
		System.out.print("- 내 용 : ");
		String content = scan.nextLine();
		
		// 입력한 값과 게시글 번호를 VO객체에 저장한다.
		JdbcBoardVO boardVo = new JdbcBoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_content(content);
		boardVo.setBoard_no(boardNo);;
		
		int cnt = service.updateBoard(boardVo);
		
		if(cnt>0) {
			System.out.println(boardNo + " 번글이 수정되었습니다.");
		}else {
			System.out.println(boardNo + " 번글 수정작업 실패!!!");
		}
		
	}
	
	
	
	// 새글을 작성하는 메서드
	private void insert() {
		System.out.println();
		scan.nextLine();  // 입력 버퍼 비우기
		
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------");
		
		System.out.print("- 제 목 : ");
		String title = scan.nextLine();
		
		System.out.print("- 작성자 : ");
		String writer = scan.nextLine();
		
		System.out.print("- 내 용 : ");
		String content = scan.nextLine();
		
		// 입력받은 데이터를 VO에 저장한다.
		JdbcBoardVO boardVo = new JdbcBoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		
		int cnt = service.insertBoard(boardVo);
		
		if(cnt>0) {
			System.out.println("새글이 추가되었습니다.");
		}else {
			System.out.println("새글 추가 실패!!!");
		}
	}
	
	
	
	// 게시판 목록을 보여주고 메뉴를 나타내고, 사용자로부터 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu(String title) {
		
		List<JdbcBoardVO> boardList = null;
		
		if(title==null || "".equals(title)) {
			boardList = service.getAllBoardList();
		}else {
			boardList = service.getSearchBoardList(title);
		}
		
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println(" NO     제  목      작성자      조회수");
		System.out.println("---------------------------------------------------");
		if(boardList==null || boardList.size()==0) {
			System.out.println("출력할 게시글이 하나도 없습니다...");
		}else {
			for(JdbcBoardVO boardVo : boardList) {
				System.out.println(boardVo.getBoard_no() + "\t" 
						+ boardVo.getBoard_title() + "\t"
						+ boardVo.getBoard_writer() + "\t"
						+ boardVo.getBoard_cnt());
			}
		}
		System.out.println("---------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업선택 >> ");
		return scan.nextInt();
	}

}













