package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;


public class MemberDaoImpl implements IMemberDao{
	private SqlMapClient smc; 
	
	// 1번
	private static MemberDaoImpl dao;
	
	// 2번
	private MemberDaoImpl() { 
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}
	

	@Override
	public int insertMember(MemberVO memVo) {
		
		int cnt = 0; 		// 반환값이 저장될 변수 선언
		
		try {
			Object obj = smc.insert("mymember.insertMember", memVo);
			
			if(obj==null) cnt = 1;
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}

	@Override
	public int deleteMember(String id) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("mymember.deleteMember", id);
			
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
	public List<MemberVO> getAllMember() {
		
		List<MemberVO> memList = null;  // 반환값이 저장될 변수 선언
		
		try {
			memList = smc.queryForList("mymember.getAllMember");
			
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public int getMemberIdCount(String id) {
		
		int count = 0;
		
		try {
			count = (int)smc.queryForObject("mymember.getMemberIdCount", id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		
		int cnt = 0;
		
		// key값 정보 : 회원ID(memid), 수정할컬럼명(field), 수정할데이터(data) 
		try {
			cnt = smc.update("mymember.updateMember2", paramMap);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}
	
}








