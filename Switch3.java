package kr.or.ddit.test;

import java.util.Scanner;

public class Switch3 {
	public static String calc() {
		//�Է�
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�����Է�(10~100)");
		int score = sc.nextInt();
			
		String res="";
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
		
		//���� -��´��
			String out = "";
			out += "�Է� �� : " + score + "\n";
			out += "��� : " + res;
			
			return out;
		
	}
	public static void main(String[] args) {
		String res = calc();
		
		System.out.println(res);

	}

}
