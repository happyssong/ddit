package kr.or.ddit.loop;

public class ForTest6 {

	public static void main(String[] args) {
		// for6��ü����
		For6 f6 = new For6();

		// hap1�޼ҵ�ȣ��-������ޱ�
		int result = f6.hap1();
		// ��������
		System.out.println("1~10������ ��" + result);
		// hap2�޼ҵ� ȣ��
		f6.hap2();

	}

}

class For6 {
	// 1~10������ ���� ���ؼ� return�ϴ� �޼ҵ� �ۼ�
	public int hap1() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		
		return sum;
	}

	// 10~1���� ���� ���ؼ� ����ϴ� �޼ҵ带 �ۼ�
	public void hap2() {
		int res = 0;
		for (int i = 10; i >= 1; i--) {
			res += i;
			
		}
		System.out.println("10~1������ ��"+res);
	}
}