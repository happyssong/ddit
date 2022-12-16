package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.JdbcBoardVO;
import kr.or.ddit.util.SqlMapClientFactory;

// 싱글톤으로 구성하기 
public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	private SqlMapClient smc;
	
	private static JdbcBoardDaoImpl dao;
	
	private JdbcBoardDaoImpl() { 
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		
		int cnt = 0;
		
		try {
			Object obj = smc.insert("jdbcboard.insertBoard", boardVo);
			if(obj==null) cnt = 1;
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.delete("jdbcboard.deleteBoard", boardNo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("jdbcboard.updateBoard", boardVo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		JdbcBoardVO boardVo = null;
		
		try {
			boardVo = (JdbcBoardVO) smc.queryForObject("jdbcboard.getBoard", boardNo);
			
		} catch (SQLException e) {
			boardVo = null;
			e.printStackTrace();
		}
		
		return boardVo;
	}

	@Override
	public List<JdbcBoardVO> getAllBoardList() {
		List<JdbcBoardVO> boardList = null;
		
		try {
			boardList = smc.queryForList("jdbcboard.getAllBoardList");
			
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		
		return boardList;
	}

	@Override
	public List<JdbcBoardVO> getSearchBoardList(String title) {
		
		List<JdbcBoardVO> boardList = null;
		
		if(title==null) title = "";
		
		try {
			boardList = smc.queryForList("jdbcboard.getSearchBoardList", title);
			
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		
		return boardList;
	}

	@Override
	public int boardCountIncrement(int boardNo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("jdbcboard.boardCountIncrement", boardNo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

}















