package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest2_2 {

	public static void main(String[] args) {
		// 수 한개 입력(1~100)

		Scanner sc = new Scanner(System.in);
		System.out.println("수 입력");
		int a = sc.nextInt();

		String res = "";
		// 비교 - 80이상이면 우수 아니면 노력

		if (a >= 80) {
			res = "우수";
		} else {
			res = "노력";

			System.out.println("입력점수 : " + a);
			System.out.println("결과 : " + res);

		}

	}
}
