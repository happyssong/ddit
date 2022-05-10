package kr.or.ddit.test;

import java.util.Scanner;

public class Switch2 {
	public static void calc() {
		
		//입력
		Scanner sc = new Scanner (System.in); 
		System.out.println("점수입력(10~100)");
		int score = sc.nextInt();
		//비교
		
		
		//출력
	}
	public static void main(String[] args) {
		//calc();  //static이 붙으면 따로 객체를 만들지 않아도 메모리가 따로 잡힘, 
		
		Switch2 sw2 = new Switch2();
		sw2.calc();   //void타입이라 변수값이 없음
		
		String res="";
		int score = 0;
		//성적비교
		switch (score/10) {
		case 10 :
		case 9 :
			res = "수";
			break;
			
		case 8 : 
			res = "우";
			break;
			
		case 7 : 
			res = "미";
			break;
			
		case 6 : 
			res = "양";
			break;
		
		default : 
			res = "가";
			break;
			}
		
		//결과출력
		System.out.println("입력점수 : "+score);
		System.out.println("결과 : " + res);
	
	}
	
		
		
		
		
	}


