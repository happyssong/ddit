package kr.or.ddit.test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("정수로 입력하세요");
		int a = sc.nextInt();
		System.out.println("입력 수 : " + a);
		++a;	
		//a  = a+1; //==a++; =>a는 1증가된 수로 덧 씌어짐
		//a의 재활용
		//==int b = a+1; 
			System.out.println("1 증가 수 : " + a);
			
			int b = 15;
			int c = b + a;
			
	
			
			int d = b + ++a;//a값 먼저 증가하고 산술
			//int d = b + a++; // 산술먼저 끝내고 a값만 증가
			System.out.println("a ="+ a+"	b="+b);
			System.out.println("c ="+ c+"	d="+d);
			
		

			
	}

}
