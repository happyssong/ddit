package kr.or.ddit.loop;

public class WhiliTest2 {

	public static void main(String[] args) {
		// 1~100�� ¦���� ���

		int i = 1;
		while (i <= 100) {
			// ¦��������
			if (i % 2 == 0) {
				// else�� �ʿ����. Ȧ������ ���ϴ� �� ������ ���
				System.out.println(i);
			}
			i++;
		}

	}

}
