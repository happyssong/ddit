package kr.or.ddit.loop;

public class WhiliTest2 {

	public static void main(String[] args) {
		// 1~100중 짝수를 출력

		int i = 1;
		while (i <= 100) {
			// 짝수인지비교
			if (i % 2 == 0) {
				// else는 필요없음. 홀수같이 비교하는 것 있으면 사용
				System.out.println(i);
			}
			i++;
		}

	}

}
