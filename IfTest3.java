package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest3 {

	public static void main(String[] args) {
		//�Է�
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է� 1~100 ���̷�");
		int su = sc. nextInt();
		
		
		//��
		String  res = "";
		if (su>=90){
			res ="��";
		}else if(su>=80){
			res ="��";
		}else if(su>=70){
			res ="��";
		}else if(su>=60){
			res ="��";
		}else {
			res ="��";
		}
		//���
		System.out.println("�Է����� : " + su);
		System.out.println("��� : " + res);
	}

}
