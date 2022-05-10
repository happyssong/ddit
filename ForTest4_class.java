package kr.or.ddit.loop;

import java.util.Scanner;

public class ForTest4_class {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("숫자입력 : ");
		int x =sc.nextInt();
		//for객체
		For4 fo = new For4();
		//gugu호출
		fo.guguProc(x);
	}

}


class For4{
	public void guguProc(int a){
		for(int i = 1; i<=9; i++){		
		System.out.println(a+"*"+i+"="+a*i);
			
		
	}
	
	}	
}