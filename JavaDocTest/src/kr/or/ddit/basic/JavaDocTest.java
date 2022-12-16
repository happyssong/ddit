package kr.or.ddit.basic;
//  한 줄 주석
/*
	JavaDoc문서 만들기 예제
*/

/**
 * 
 * @author SEM-PC
 * @version 1.0
 * 
 * <p>
 * 파일명 : JavaDocTest.java<br>
 * 설 명 : JavaDoc문서 작성을 위한 연습용 interface<br><br>
 * 
 * 변경 이력<br>
 * ------------------------<br>
 * 변경 일자 : 2020-07-15<br>
 * 변경한 사람 : 홍길동<br>
 * 변경 내용 : 최조 생성<br>
 * ------------------------<br>
 * </p>
 *
 */
public interface JavaDocTest {
	/**
	 * 메서드명 : add<br>
	 * 설 명 : 정수형 인수 2개를 받아서 처리하는 메서드<br>
	 * 
	 * @param a 첫번째 정수형 변수
	 * @param b 두번째 정수형 변수
	 */
	public void add(int a, int b);
	
	/**
	 * 메서드명 : sub<br>
	 * 설 명 : 정수형 인수 2개를 받아서 처리한 후 결과를 반환하는 메서드<br>
	 *  
	 * @param x 첫번째 매개변수(정수형)
	 * @param y 두번째 매개변수(정수형)
	 * @return 처리된 결과를 정수형으로 반환한다.
	 */
	public int sub(int x, int y);
	
	/**
	 * 메서드명 : mul<br>
	 * 설 명 : 매개변수가 없는 메서드<br>
	 * 
	 * @return 정수형 데이터 반환
	 */
	public int mul();
	
	
}












