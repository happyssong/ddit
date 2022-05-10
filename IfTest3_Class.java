package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest3_Class {

	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력");
		int su = sc.nextInt();
		//Score메소드 호출 - 결과값을 return
		Score3 sco3 = new Score3();
		String str = sco3.ssc(su);
		//출력
		System.out.println("입력 점수 : " + su);
		System.out.println("결과 : " + str);
	}

}

class Score3{
	public String ssc(int su){
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
		return res;
	
}

	
}