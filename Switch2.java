package kr.or.ddit.test;

import java.util.Scanner;

public class Switch2 {
	public static void calc() {
		
		//�Է�
		Scanner sc = new Scanner (System.in); 
		System.out.println("�����Է�(10~100)");
		int score = sc.nextInt();
		//��
		
		
		//���
	}
	public static void main(String[] args) {
		//calc();  //static�� ������ ���� ��ü�� ������ �ʾƵ� �޸𸮰� ���� ����, 
		
		Switch2 sw2 = new Switch2();
		sw2.calc();   //voidŸ���̶� �������� ����
		
		String res="";
		int score = 0;
		//������
		switch (score/10) {
		case 10 :
		case 9 :
			res = "��";
			break;
			
		case 8 : 
			res = "��";
			break;
			
		case 7 : 
			res = "��";
			break;
			
		case 6 : 
			res = "��";
			break;
		
		default : 
			res = "��";
			break;
			}
		
		//������
		System.out.println("�Է����� : "+score);
		System.out.println("��� : " + res);
	
	}
	
		
		
		
		
	}


