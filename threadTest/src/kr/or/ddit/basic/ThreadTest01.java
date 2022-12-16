package kr.or.ddit.basic;

public class ThreadTest01 {

	public static void main(String[] args) {
		// 	싱글 쓰레드 프로그램
		// 	'*'문자를 200개 출력하는 부분과 '$'문자를 200개 
		//	출력하는 프로그램을 작성하려고 한다.
		
		for(int i=1; i<=200; i++) {
			System.out.print("*");
		}
		
		System.out.println();
		System.out.println();

		for(int i=1; i<=200; i++) {
			System.out.print("$");
		}

		
	}

}
