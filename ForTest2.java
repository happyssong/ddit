package kr.or.ddit.loop;

import java.util.Scanner;

public class ForTest2 {

	public static void main(String[] args) {
		// �Է�
		Scanner sc =new Scanner(System.in);
		System.out.println("���� �Է�");
		int a = sc.nextInt();

		// For2 class��ü����
		For2 fo = new For2();		
		// hap�Լ� ȣ���ؼ� ���ϰ������ �޴´�.
		int res = fo.hap(a);
		
		// ���
		System.out.println(res);
	}

}

class For2 {
	int sum = 0;//��������
	public int hap(int a) {//a=�Է¹��� ��
		//1~�Է¹��� ������ �ձ��ϰ� �����Ѵ�
		 for(int i = 0; i<=a; i++ ){
			 sum +=i; 
			 //i�� ����ī���� ����
			 
	}return sum;
		
		
	}
}
			
		
	
	

   

		
	