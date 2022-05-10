package kr.or.ddit.loop;

import java.util.Scanner;

public class ForTest5 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("숫자입력 : ");
		int x =sc.nextInt();
		//for객체
		For5 f5 = new For5();
		//gugu호출
		String res =f5.guguProc(x);
		
		System.out.println(res);
	}

}

class For5{
	public String guguProc(int a) {
		String str = "";
		for(int i =1; i<=9; i++){
			str+= a+"*"+i+"="+a*i+"\n";
		}
		return str;
	}
}