package kr.or.ddit.loop;

import java.util.Scanner;

public class WhileTest4 {

	public static void main(String[] args) {
		//10�� �ݺ�
		Scanner scr = new Scanner(System.in);
		
				
		
		//¦���� ���� ����
		String a = "";
		//Ȧ���� ���� ����
		String b = "";
		//�ʱ��
		int i =1;
		while (i<=10) {// i ==�ݺ�Ƚ�� 10��
			//�Է¿��� ¦��, Ȧ�� ����!
			System.out.println(i+"��° �Է� :");
			int su =scr.nextInt();
			//¦������ Ȧ������ �Ǵ� 
			if(su%2==0){
				a+=su+" ";
			}else {
				b+=su+" ";
			}//������
			i++;
			
		}
	System.out.println("¦�� : "+a);
	System.out.println("Ȧ�� : "+b);
	}

	
}
