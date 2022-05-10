package kr.or.ddit.loop;

public class WhileTest3 {

	public static void main(String[] args) {
		// 1~100 짝수의 합& 홀수의 합 구하기!
		// 짝수,홀수합 변수 각각 선언

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
		System.out.println("짝수의합 " + a);
		System.out.println("홀수의 합" + b);
	}
}