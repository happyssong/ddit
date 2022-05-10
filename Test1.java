package kr.or.ddit.test;

public class Test1 {
		// java 파일명과 이름이 같아야함
	public static void main(String[] args) {
		// Sample class사용 - sample클래스의 객체변수생성
		Sample samp = new Sample();

		// 리턴결과형 변수이름 = 메소드이름(값); -> 메소드 호출
		int res = samp.add(23, 56);

		System.out.println("23 + 56 =" + res);

		int res2 = samp.add(56, 12);
		System.out.println("56 + 12 = " + res);

		samp.calc(10, 55);
		samp.calc(45, 89);

	}

}

class Sample {

	// 기능부여, 메인메소드 없음, 사용당하는 클래스이기 때문에. - 메소드 정의, 선언
	// 메소드 형식
	// public 리턴결과형(데이터타입) 메소드이름(매개변수){ return 결과값; }

	public int add(int a, int b) {
		int result = a + b;
		// 지역변수
		return result;

	}

	public void calc(int x, int y) {
		// public void 메소드이름(매개변수){} - void는 return 값 없음.
		int result = x + y;
		// 지역변수
		System.out.println(x + "+" + y + "=" + result);

	}

}
