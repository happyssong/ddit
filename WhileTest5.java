package kr.or.ddit.loop;

import java.util.Scanner;

public class WhileTest5 {

	public static void main(String[] args) {
		
		//입력
		Scanner sc =new Scanner(System.in);
		System.out.println("숫자 입력 : ");
		//구구단출력 - while
		int i = 1;
		int j =0;
		int su = sc.nextInt();
		
		while(i<=9) {
			j=su*i;
			
			System.out.println(su+"*"+i+"="+j);
			i++;
		}
	}

}
