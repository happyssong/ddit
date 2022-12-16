package kr.or.ddit.prod.controller;

import java.util.List;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdTest {
	
	//service객체 필요
	private IProdService   service;
	
	//생성자 - 변수초기화 
	public ProdTest() {
		service  =  ProdServiceImpl.getServiceInstance();
	}

	public void selectAll() {
	   List<ProdVO> list = 	service.selectAll();
	   
	    for(ProdVO  vo : list) {
		   
		   String id  =  vo.getProd_id();
		   String name =   vo.getProd_name();
		   String lgu  =   vo.getProd_lgu();
		   int cost    =   vo.getProd_cost();
		   int price   =  vo.getProd_price();
		   int sale     =   vo.getProd_sale();
		   String buyer =   vo.getProd_buyer();
		   
		   System.out.println(id + "\t" + name + "\t" + 
		                      lgu + "\t" + cost + "\t" +
				              price+ "\t" + sale + "\t" + buyer);
	    }
	}
	
	public static void main(String[] args) {
		
		ProdTest  test = new ProdTest();
		test.selectAll();

	}
}
