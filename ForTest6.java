package kr.or.ddit.loop;

public class ForTest6 {

	public static void main(String[] args) {
		// for6객체생성
		For6 f6 = new For6();

		// hap1메소드호출-결과값받기
		int result = f6.hap1();
		// 결과값출력
		System.out.println("1~10까지의 합" + result);
		// hap2메소드 호출
		f6.hap2();

	}

}

class For6 {
	// 1~10까지의 합을 구해서 return하는 메소드 작성
	public int hap1() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		
		return sum;
	}

	// 10~1까지 합을 구해서 출력하는 메소드를 작성
	public void hap2() {
		int res = 0;
		for (int i = 10; i >= 1; i--) {
			res += i;
			
		}
		System.out.println("10~1까지의 합"+res);
	}
}