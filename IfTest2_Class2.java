package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest2_Class2 {

	public static void main(String[] args) {
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է�");
		int su = sc.nextInt();

		// Score comp�޼ҵ� ȣ�� - ����� �ޱ�
		Score sco = new Score();
		String str = sco.comp(su);

		// ���
		System.out.println("�Է� ���� : " + su);
		System.out.println("��� : " + str);
	}

}

class Score {

	public String comp(int a) {

		String result = "";
		// a���� ��
		if (a >= 80) {
			result = "���";
		} else {
			result = "���";
		}
		return result; // ���� void class�̸� ���⼭ ��� �����ʿ����
	}
}