package kr.or.ddit.test;


import java.util.Scanner;
public class Switch1 {

	public static void main(String[] args) {
		
		// �Է� 1~100
	Scanner sc = new Scanner(System.in);
	
	System.out.println("�����Է�(10~100)");int score = sc.nextInt();
		
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
		
		//������
		System.out.println("�Է����� : "+score);
		System.out.println("��� : " + res);
	
	}

}
