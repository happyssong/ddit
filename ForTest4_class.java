package kr.or.ddit.loop;

import java.util.Scanner;

public class ForTest4_class {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("�����Է� : ");
		int x =sc.nextInt();
		//for��ü
		For4 fo = new For4();
		//guguȣ��
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