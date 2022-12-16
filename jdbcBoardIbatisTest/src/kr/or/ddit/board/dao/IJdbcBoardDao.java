package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.JdbcBoardVO;

public interface IJdbcBoardDao {
	
	/**
	 * JdbcBoardVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param boardVo insert할 데이터가 저장된 JdbcBoardVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertBoard(JdbcBoardVO boardVo);
	
	/**
	 * 게시글 번호를 인수값으로 받아서 해다 게시글 정보를 삭제하는 메서드
	 * 
	 * @param boardNo 삭제할 게시글 번호
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteBoard(int boardNo);
	
	/**
	 * 인수값으로 받은 JdbcBoardVO객체 자료를 이용하여 update하는 메서드
	 * 
	 * @param boardVo update할 자료가 저장된 JdbcBoardVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateBoard(JdbcBoardVO boardVo);
	
	/**
	 * 게시글 번호를 인수값으로 받아서 해당 게시글 정보를 가져와 반환하는 메서드
	 * 
	 * @param boardNo 가져올 게시글 번호
	 * @return 해당 게시글 번호에 맞는 게시글 정보가 저장된 JdbcBoardVO객체,
	 * 			자료가 없으면 null 반환
	 */
	public JdbcBoardVO getBoard(int boardNo);
	
	/**
	 * DB의 게시판 테이블의 전체 데이터를 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return JdbcBoardVO객체가 저장된 List객체
	 */
	public List<JdbcBoardVO> getAllBoardList();
	
	/**
	 * 검색할 게시글 제목을 인수값으로 받아서 검색 결과를 반환하는 메서드
	 * 
	 * @param title 검색할 게시글의 제목
	 * @return 검색 결과가 저장된 List객체
	 */
	public List<JdbcBoardVO> getSearchBoardList(String title);
	
	/**
	 * 게시글 번호를 인수값으로 받아서 해당 게시글의 조회수를 증가하는 메서드
	 * 
	 * @param boardNo 조회수를 증가할 게시글의 번호
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int boardCountIncrement(int boardNo);
}



















