package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	
	private MemberDaoImpl dao;  // MemberDao객체 변수 선언
	private static MemberServiceImpl memService;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();	// MemberDao객체 생성
	}

	public static MemberServiceImpl getInstance(){
		if(memService==null) memService = new MemberServiceImpl();
		return memService;
	}

	@Override
	public int getMemberCount() {
		return dao.getMemberCount();
	}

	@Override
	public List<MemberVO> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public MemberVO getMember(String memId) {
		return dao.getMember(memId);
	}


}
