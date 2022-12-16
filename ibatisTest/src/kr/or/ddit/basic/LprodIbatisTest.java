package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.vo.LprodVO;

public class LprodIbatisTest {
	// iBatis를 이용해서 DB자료를 처리하는 순서 및 방법
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			// 1. iBatis의 환경설정파일(sqlMapConfig.xml)을 읽어와서 초기화 작업을 진행한다.
			
			// 1-1. 문자 인코딩 케릭터셋 설정
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			
			// 1-2. 환경설정 파일을 읽어올 스트림 객체 생성
			Reader rd = 
				Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			// 1-3. 위에서 생성한 스트림 객체를 이용하여 환경 설정 파일을 읽어와 실행 시켜 
			//		환경 설정을 완성한 후 SQL문을 호출해서 실행할 객체를 생성한다.
			//		(SqlMapClient객체를 이용하여 SQL문을 호출해서 실행한다.)
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();		// 스트림 닫기
			//-----------------------------------------------------
			
			
			// 2. 실행할 SQL문이 작성된 태그를 호출해서 실행하기
			
			/*
			// 2-1. insert 연습
			System.out.println("insert 작업 시작... ");
			
			System.out.print("Lprod_id 입력 >> ");
			int lprodId = scan.nextInt();
			
			System.out.print("Lprod_gu 입력 >> ");
			String lprodGu = scan.next();
			
			System.out.print("Lprod_nm 입력 >> ");
			String lprodNm = scan.next();
			
			// insert할 데이터를 VO객체에 저장한다.
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(lprodId);
			lvo.setLprod_gu(lprodGu);
			lvo.setLprod_nm(lprodNm);
			
			// SqlMapClient객체를 이용하여 처리할 쿼리문을 호출해서 실행한다.
			// 형식) SqlMapClient객체변수.insert("namespace속성값.id속성값", 파라미터클래스);
			//		반환값 : insert성공 : null, 실패 : 오류객체
			Object obj = smc.insert("lprod.insertLprod", lvo);
			
			if(obj==null) {
				System.out.println("insert 작업 성공!!!");
			}else {
				System.out.println("insert 작업 실패~~~");
			}
			
			System.out.println("----------------------------------------");
			*/
			
			/*
			// 2-2. update 연습
			System.out.println("update 시작...");
			System.out.print("수정할 Lprod_gu 입력 : ");
			String lgu = scan.next();
			
			System.out.print("새로운 Lprod_id 입력 : ");
			int lid = scan.nextInt();
			
			System.out.print("새로운 Lprod_nm 입력 : ");
			String lnm = scan.next();
			
			// 입력받은 데이터를 VO에 저장한다.
			LprodVO lvo2 = new LprodVO();
			lvo2.setLprod_gu(lgu);
			lvo2.setLprod_id(lid);
			lvo2.setLprod_nm(lnm);
			
			// update 실행
			// 형식) sqlMapClient객체변수.update("namespace속성값.id속성값", 파라미터클래스)
			//		반환값 : 작업에 성공한 레코드 수
			int cnt = smc.update("lprod.updateLprod", lvo2);
			if(cnt>0) {
				System.out.println("update 성공.");
			}else {
				System.out.println("update 실패.");
			}
			System.out.println("------------------------------------------");
			*/
			
			/*
			// 2-3. delete 연습
			System.out.println("delete 시작...");
			System.out.print("삭제할 Lprod_gu 입력 : ");
			String lgu = scan.next();
			
			lgu = (lgu + "   ").substring(0,4);
			
			
			// delete 실행
			// 형식) sqlMapClient객체변수.delete("namespace속성값.id속성값", 파라미터클래스)
			// 		반환값 : 작업에 성공한 레코드 수
			int cnt2 = smc.delete("lprod.deleteLprod", lgu);
			if(cnt2>0) {
				System.out.println("delete 작업 성공");
			}else {
				System.out.println("delete 작업 실패");
			}
			System.out.println("------------------------------------------");
			*/
			
			// 2-4. select 연습
			
			/*
			// 1) select의 결과가 여러개인 경우
			System.out.println("select 시작 (결과가 여러개일 경우...)");
			
			// select의 결과가 여러개일 경우에는 queryForList()메서드를 사용하는데
			// 이 메서드는 여러개의 레코드 각각을 VO에 담은 후 이 VO데이터들을
			// List에 추가해 주는 작업을 자동으로 수행한다.
			// 형식) sqlMapClient객체변수.queryForList("namespace속성값.id속성값", 파라미터클래스)
			List<LprodVO> lprodList = smc.queryForList("lprod.getAllLprod");
			
			for(LprodVO lvo3 : lprodList) {
				System.out.println("ID : " + lvo3.getLprod_id());
				System.out.println("GU : " + lvo3.getLprod_gu());
				System.out.println("NM : " + lvo3.getLprod_nm());
				System.out.println("--------------------------");
			}
			System.out.println("출력 끝...");
			System.out.println("------------------------------------------");
			*/
			
			// 2) select의 결과가 1개의 레코드일 경우
			System.out.println("select 시작 (결과가 1개일 경우...)");
			System.out.print("검색할 Lprod_gu 입력 : ");
			String lgu3 = scan.next();
			
			// select한 결과가 1개가 확실할 경우에는 queryForObject()메서드를 사용한다.
			// 형식) sqlMapClient객체변수.queryForObject("namespace속성값.id속성값", 파라미터클래스)
			//		반환값 : 처리 결과가 1개일 경우(정상) ==> 해당 객체 반환
			//			   처리 결과가 여러개일 경우 ==> Exception객체 반환
			//			   처리 결과가 없을 경우 ==> null 반환
			
			LprodVO lvo4 = (LprodVO)smc.queryForObject("lprod.getLprod", lgu3);
			
			if(lvo4==null) {
				System.out.println("검색 결과가 하나도 없습니다...");
				return;
			}
			
			System.out.println("... 검색 결과 ...");
			System.out.println("ID : " + lvo4.getLprod_id());
			System.out.println("GU : " + lvo4.getLprod_gu());
			System.out.println("NM : " + lvo4.getLprod_nm());
			System.out.println("--------------------------");
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}











