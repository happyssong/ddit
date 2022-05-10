package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest3 {

	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("수를 입력 1~100 사이로");
		int su = sc. nextInt();
		
		
		//비교
		String  res = "";
		if (su>=90){
			res ="수";
		}else if(su>=80){
			res ="우";
		}else if(su>=70){
			res ="미";
		}else if(su>=60){
			res ="양";
		}else {
			res ="가";
		}
		//출력
		System.out.println("입력점수 : " + su);
		System.out.println("결과 : " + res);
	}

}
