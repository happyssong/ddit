package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest3_Class {

	public static void main(String[] args) {
		//�Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է�");
		int su = sc.nextInt();
		//Score�޼ҵ� ȣ�� - ������� return
		Score3 sco3 = new Score3();
		String str = sco3.ssc(su);
		//���
		System.out.println("�Է� ���� : " + su);
		System.out.println("��� : " + str);
	}

}

class Score3{
	public String ssc(int su){
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
		return res;
	
}

	
}