package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest2_Class {

	public static void main(String[] args) {
		// �Է�

		Scanner sc = new Scanner(System.in);
		System.out.println("�����Է�");
		int su = sc.nextInt();

		// Score comp�޼ҵ� ȣ�� - ����� �ޱ�
		Score2 sco = new Score2();
		String str = sco.comp(su);

		// ���
		System.out.println("�Է����� : " + su);
		System.out.println("��� : " + str);
	}

}

class Score2 {

	public String comp(int a) {

		String res = "";
		// a���� ��
		if (a >= 80) {
			res = "���"; // result = ���
		} else {
			res = "���";
		}
		return res;// ���� void class�̸� ���⼭ ��� �����ʿ����
	}
}
