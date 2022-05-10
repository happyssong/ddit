package kr.or.ddit.loop;

import java.util.Scanner;

public class WhileTest4 {

	public static void main(String[] args) {
		//10번 반복
		Scanner scr = new Scanner(System.in);
		
				
		
		//짝수방 변수 선언
		String a = "";
		//홀수방 변수 선언
		String b = "";
		//초기식
		int i =1;
		while (i<=10) {// i ==반복횟수 10번
			//입력에서 짝수, 홀수 구분!
			System.out.println(i+"번째 입력 :");
			int su =scr.nextInt();
			//짝수인지 홀수인지 판단 
			if(su%2==0){
				a+=su+" ";
			}else {
				b+=su+" ";
			}//증가식
			i++;
			
		}
	System.out.println("짝수 : "+a);
	System.out.println("홀수 : "+b);
	}

	
}
