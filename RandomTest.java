package kr.or.ddit.test;

public class RandomTest {

	public static void main(String[] args) {
		
		
		//Ŭ���� ��ü ����
		RandomTest test = new RandomTest();
		test.randProc();		
	}

	
	public void randProc() {
		
		
		//�ֻ��� ������ - ���� �߻� 1~6
		int rand = (int)(Math.random()*6+1);
		
		//��
		/*if(rand == q) {
			
		}else if(rand == 1)
		�� 6�� �ݺ��ؾ���. ����ġ������ �ٲ㺸��
		*/
		
		
		String str = "";
		switch(rand) {
		case 1:
			str = "���� 1��";
			break;
		case 2:
			str = "���� 2��";
			break;
		case 3:
			str = "���� 3��";
			break;
		case 4:
			str = "���� 4��";
			break;
		case 5:
			str = "���� 5��";
			break;
		case 6:
			str = "���� 6��";
			break;
		}
		
		
		//���
		System.out.println("�ֻ��� �� :" + rand +"\n");
		System.out.println("ȹ���ǰ :"+str);
		
	}
}
