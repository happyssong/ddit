package kr.or.ddit.test;

public class Test1 {
		// java ���ϸ�� �̸��� ���ƾ���
	public static void main(String[] args) {
		// Sample class��� - sampleŬ������ ��ü��������
		Sample samp = new Sample();

		// ���ϰ���� �����̸� = �޼ҵ��̸�(��); -> �޼ҵ� ȣ��
		int res = samp.add(23, 56);

		System.out.println("23 + 56 =" + res);

		int res2 = samp.add(56, 12);
		System.out.println("56 + 12 = " + res);

		samp.calc(10, 55);
		samp.calc(45, 89);

	}

}

class Sample {

	// ��ɺο�, ���θ޼ҵ� ����, �����ϴ� Ŭ�����̱� ������. - �޼ҵ� ����, ����
	// �޼ҵ� ����
	// public ���ϰ����(������Ÿ��) �޼ҵ��̸�(�Ű�����){ return �����; }

	public int add(int a, int b) {
		int result = a + b;
		// ��������
		return result;

	}

	public void calc(int x, int y) {
		// public void �޼ҵ��̸�(�Ű�����){} - void�� return �� ����.
		int result = x + y;
		// ��������
		System.out.println(x + "+" + y + "=" + result);

	}

}
