package kr.or.ddit.loop;

import java.util.Scanner;

public class ForTest4 {

	public static void main(String[] args) {
		//�Է� 5
		Scanner sc =new Scanner(System.in);
		System.out.println("������ ���� �Է��ϼ���");
		int su = sc.nextInt();
		
				//������ ���
				for (int i=1; i<=9; i++){
					System.out.println(su+"*"+i+"="+su*i);
				}
		
		
	}
}