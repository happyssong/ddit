package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;   // DAO객체가 저장될 변수 선언
	
	private static MemberServiceImpl service;	// 1번
	
	// 생성자
	//public MemberServiceImpl() {
	private MemberServiceImpl() {		// 2번
		//dao = new MemberDaoImpl();  // DAO객체 생성
		dao = MemberDaoImpl.getInstance();
	}
	
	// 3번
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	

	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo); 
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberIdCount(String id) {
		return dao.getMemberIdCount(id);
	}


	@Override
	public int updateMember2(Map<String, String> paramMap) {
		return dao.updateMember2(paramMap);
	}

}
