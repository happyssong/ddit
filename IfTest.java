package kr.or.ddit.test;

import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		SampleComp ss = new SampleComp();
		Scanner sc = new Scanner(System.in);
		System.out.println("ù��° �� : ");
		int x = sc.nextInt();
		System.out.println("�ι�° �� : ");
		int y = sc.nextInt();

		ss.comp(x, y);
	}

}

class SampleComp {

	// �޼ҵ� ���� - �ΰ��� ���� �Է¹޾Ƽ�
	// ū ���� ���
	public void comp(int a, int b) {
		String res = "		";

		if (a == b) {
			res = "a�� b�� ���� �� �Դϴ�";
		} else if (a >= b) {
			res = "a�� �� ū �� �Դϴ�";
		} else {
			res = "b�� �� ū���Դϴ�";
		}

		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("res=" + res);

	}
}
