package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest2_2 {

	public static void main(String[] args) {
		// �� �Ѱ� �Է�(1~100)

		Scanner sc = new Scanner(System.in);
		System.out.println("�� �Է�");
		int a = sc.nextInt();

		String res = "";
		// �� - 80�̻��̸� ��� �ƴϸ� ���

		if (a >= 80) {
			res = "���";
		} else {
			res = "���";

			System.out.println("�Է����� : " + a);
			System.out.println("��� : " + res);

		}

	}
}
