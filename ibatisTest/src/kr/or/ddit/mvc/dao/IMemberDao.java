package kr.or.ddit.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서 Service에게 전달하는 DAO의 interface
 * 
 * 각 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * 
 * @author SEM-PC
 *
 */
public interface IMemberDao {
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo DB에 insert할 자료가 저장된 MemberVO객체
	 * @return insert성공 : 1, insert실패 : 0
	 */
	public int insertMember(MemberVO memVo );
	
	/**
	 * 회원ID를 인수값으로 받아서 해당 회원 정보를 삭제하는 메서드
	 * 
	 * @param id 삭제할 회원ID
	 * @return 삭제성공:1, 삭제실패:0
	 */
	public int deleteMember(String id);
	
	/**
	 * MemberVO자료를 이용하여 회원 정보를 수정하는 메서드
	 * 
	 * @param memVo update할 회원 정보가 저장된 MemberVO객체
	 * @return 수정성공:1, 수정실패:0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * 전체 회원 정보를 가져와서 List에 담아서 반환하는 메서드
	 * 
	 * @return MemberVO객체가 저장된 List객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원ID를 인수값으로 받아서 해당 회원ID의 개수를 반환하는 메서드
	 * 
	 * @param id 검색할 회원ID
	 * @return 검색된 회원ID의 개수
	 */
	public int getMemberIdCount(String id);
	
	/**
	 * Map에 저장된 정보를 이용하여 원하는 항목을 수정하는 메서드
	 *   ==> key값 정보 : 회원ID(memid), 수정할컬럼명(field), 수정할데이터(data) 
	 * 
	 * @param paramMap 회원ID, 수정할컬럼명, 수정할데이터가 저장될 Map객체
	 * @return 수정성공 : 1, 수정실패 : 0
	 */
	public int updateMember2(Map<String, String> paramMap);
	
}
















