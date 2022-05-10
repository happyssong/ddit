package kr.or.ddit.loop;

import java.util.Scanner;

public class ForTest2 {

	public static void main(String[] args) {
		// 입력
		Scanner sc =new Scanner(System.in);
		System.out.println("숫자 입력");
		int a = sc.nextInt();

		// For2 class객체생성
		For2 fo = new For2();		
		// hap함수 호출해서 리턴결과값을 받는다.
		int res = fo.hap(a);
		
		// 출력
		System.out.println(res);
	}

}

class For2 {
	int sum = 0;//누적변수
	public int hap(int a) {//a=입력받은 수
		//1~입력받은 수까지 합구하고 리턴한다
		 for(int i = 0; i<=a; i++ ){
			 sum +=i; 
			 //i는 루프카운터 변수
			 
	}return sum;
		
		
	}
}
			
		
	
	

   

		
	