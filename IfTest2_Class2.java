package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest2_Class2 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력");
		int su = sc.nextInt();

		// Score comp메소드 호출 - 결과값 받기
		Score sco = new Score();
		String str = sco.comp(su);

		// 출력
		System.out.println("입력 점수 : " + su);
		System.out.println("결과 : " + str);
	}

}

class Score {

	public String comp(int a) {

		String result = "";
		// a값을 비교
		if (a >= 80) {
			result = "우수";
		} else {
			result = "노력";
		}
		return result; // 만약 void class이면 여기서 출력 리턴필요없음
	}
}