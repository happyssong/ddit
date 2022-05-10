package kr.or.ddit.test;


import java.util.Scanner;
public class Switch1 {

	public static void main(String[] args) {
		
		// 입력 1~100
	Scanner sc = new Scanner(System.in);
	
	System.out.println("점수입력(10~100)");int score = sc.nextInt();
		
	String res="";
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
