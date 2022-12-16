package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;


/*
	실제 DB와 연결해서 SQL문을 수행하여
	결과를 작성하여 Service에 전달하는 역할을 수행한다.
*/
public class MemberDaoImpl implements IMemberDao {
	private SqlMapClient smc;
	private static MemberDaoImpl memDao;
	
	private MemberDaoImpl(){	
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static MemberDaoImpl getInstance(){
		if(memDao==null) memDao = new MemberDaoImpl();
		
		return memDao;
	}
	

	@Override
	public int getMemberCount(){
		
		int cnt = 0;
		try {
			cnt = (int)smc.queryForObject("mymember.getMemberCount");
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
			
		return cnt;
	}

	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> memList = null;
		try {
			memList = smc.queryForList("mymember.getMemberList");
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("mymember.insertMember", memVo);
			if(obj==null) cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = smc.delete("mymember.deleteMember", memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;
		try {
			cnt = smc.update("mymember.updateMember", memVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public MemberVO getMember(String memId) {
		MemberVO memVo = null;
		try {
			memVo = (MemberVO)smc.queryForObject("mymember.getMember", memId);
		} catch (SQLException e) {
			memVo = null;
			e.printStackTrace();
		}
		return memVo;
	}

	
}















