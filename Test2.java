package kr.or.ddit.test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("������ �Է��ϼ���");
		int a = sc.nextInt();
		System.out.println("�Է� �� : " + a);
		++a;	
		//a  = a+1; //==a++; =>a�� 1������ ���� �� ������
		//a�� ��Ȱ��
		//==int b = a+1; 
			System.out.println("1 ���� �� : " + a);
			
			int b = 15;
			int c = b + a;
			
	
			
			int d = b + ++a;//a�� ���� �����ϰ� ���
			//int d = b + a++; // ������� ������ a���� ����
			System.out.println("a ="+ a+"	b="+b);
			System.out.println("c ="+ c+"	d="+d);
			
		

			
	}

}
