package kr.or.ddit.basic;

import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.LprodVO;

// JdbcTest프로젝트에 있는 JdbcTest05.java를 iBatis로 처리되도록 하시오.

public class JdbcToIbatisTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {
			/*
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			Reader rd = 
				Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");

			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close(); // Reader객체 닫기
			*/
			
			SqlMapClient smc = SqlMapClientFactory.getSqlMapClient(); 
				
			// ------------------------------------------------------------------------------------
			
			int max = (int) smc.queryForObject("jdbc.getMaxId");
			
			// 입력받은 상품분류코드(lprod_gu)가 이미 등록되어 있으면 다시 입력받아서 처리한다.
			String gu; // 상품분류 코드가 저장될 변수 선언
			int count = 0; // 입력한 상품분류 코드의 개수가 저장될 변수 선언
			do {
				System.out.print("상품 분류 코드(LPROD_GU) 입력 : ");
				gu = scan.next();

				count = (int) smc.queryForObject("jdbc.getCountLprodGu", gu);

				if (count > 0) {
					System.out.println("입력한 상품 분류 코드 " + gu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요.");
				}
			} while (count > 0);

			// -----------------------------------------------------------------------------------------------

			System.out.print("상품 분류명(LPROD_NM) 입력 : ");
			String nm = scan.next();

			LprodVO lpvo = new LprodVO();
			lpvo.setLprod_gu(gu);
			lpvo.setLprod_id(max);
			lpvo.setLprod_nm(nm);

			Object obj = smc.insert("jdbc.insertLprod", lpvo);

			if (obj == null) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}