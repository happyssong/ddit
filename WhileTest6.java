package kr.or.ddit.loop;

public class WhileTest6 {

	public static void main(String[] args) {
		
		//1~100 ���� 5���� �߻��Ͽ� ���� ���Ͽ���
		
		int i = 1;
		int sum =0;
		int a;
		String rend =  "";
		while(i<=5) {
			a=(int)(Math.random()*100+1);
			sum+=a;
			rend=a+" ";
			System.out.print(rend);
			i++;
		}
		System.out.println("�հ� : " +sum);
			

	}

}
