package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest2 {

	public static void main(String[] args) {

		// �� �Ѱ� �Է�(1~100)

		Scanner sc = new Scanner(System.in);
		System.out.println("�� �Է�");
		int a = sc.nextInt();
		
		
		// �� - 80�̻��̸� ��� �ƴϸ� ���
		
		if (a >= 80) {
			System.out.println("���");
		} else {
			System.out.println("���");

		}

	}

}
