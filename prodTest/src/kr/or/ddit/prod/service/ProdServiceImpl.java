package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {

	//dao객체가 필요
	//자신의객체를 생성해서 리턴 
	private IProdDao dao;
	private static IProdService   service;
	
	
	//생성자 
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getDaoInstance();
	}
	
	public static  IProdService  getServiceInstance() {
		
		if(service == null)   service = new ProdServiceImpl();
		
		return service;
	}
	
	
	@Override
	public List<ProdVO> selectAll() {
		//List<ProdVO>  list = null;
		//list = dao.selectAll();
		//return list;
		
		return  dao.selectAll();
	}
}
