package kr.or.ddit.loop;

public class WhileTest3 {

	public static void main(String[] args) {
		// 1~100 ¦���� ��& Ȧ���� �� ���ϱ�!
		// ¦��,Ȧ���� ���� ���� ����

		int a = 0;
		int b = 0;

		int i = 1;
		while (i <= 100) {
			if (i % 2 == 0) {
				a += i;

			} else {
				b += i;
			}
			i++;
		}
		System.out.println("¦������ " + a);
		System.out.println("Ȧ���� ��" + b);
	}
}