package kr.or.ddit.loop;

import java.util.Scanner;

public class ForTest4 {

	public static void main(String[] args) {
		//입력 5
		Scanner sc =new Scanner(System.in);
		System.out.println("구구단 수를 입력하세요");
		int su = sc.nextInt();
		
				//구구단 출력
				for (int i=1; i<=9; i++){
					System.out.println(su+"*"+i+"="+su*i);
				}
		
		
	}
}