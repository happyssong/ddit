package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao{
	private static Logger logger = Logger.getLogger(MemberDaoImpl.class);
	
	// 1번
	private static MemberDaoImpl dao;
	
	// 2번
	private MemberDaoImpl() { }
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}
	

	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; 		// 반환값이 저장될 변수 선언
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성...");
			
			String sql = "insert into mymember "
					+ "(mem_id, mem_pass, mem_name, mem_tel, mem_addr ) "
					+ " values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());
			
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL문 : " + sql);
			logger.debug("사용데이터 : [" + memVo.getMem_id() + ", " 
					+ memVo.getMem_pass() + ", " + memVo.getMem_name() 
					+ ", " + memVo.getMem_tel() + ", " 
					+ memVo.getMem_addr() + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("작업 성공~~");
			
		} catch (SQLException e) {
			logger.error("작업 실패 : " + e);
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { 
					pstmt.close(); 
					logger.info("PreparedStatement객체 반납...");
				}catch(SQLException e) {}
			if(conn!=null) try { 
					conn.close();
					logger.info("Connection객체 반납...");
				}catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "delete from mymember where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "update mymember set "
					+ " mem_pass = ? , mem_name = ? ,"
					+ " mem_tel = ? , mem_addr = ? "
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MemberVO> memList = null;  // 반환값이 저장될 변수 선언
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			memList = new ArrayList<MemberVO>();  // List객체 생성
			while(rs.next()) {	// 레코드 개수만큼 반복
				MemberVO memVo = new MemberVO();  // 1개의 레코드가 저장될 변수 선언
				
				// VO객체에 DB에서 가져온 컬럼값들을 저장한다.
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_pass(rs.getString("mem_pass"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(memVo);  // 1개의 레코드가 저장된 MemberVO객체를 List에 추가한다.
			}
			
			
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); }catch(SQLException e) {}
			if(stmt!=null) try { stmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		
		return memList;
	}

	@Override
	public int getMemberIdCount(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select count(*) cnt from mymember "
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); }catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		// key값 정보 : 회원ID(memid), 수정할컬럼명(field), 수정할데이터(data) 
		try {
			conn = DBUtil3.getConnection(); 
			
			// paramMap에 저장된 key값을 이용하여 쿼리문을 작성하고,
			// 쿼리문에 들어갈 데이터를 셋팅하는 작업을 진행한다.
			String sql = "update mymember set " 
					+ paramMap.get("field") + " = ? where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramMap.get("data"));
			pstmt.setString(2, paramMap.get("memid"));
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		
		return cnt;
	}
	
}








