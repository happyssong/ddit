package kr.or.ddit.basic;

// 쓰레드에서 객체를 공통으로 사용하는 예제

/*
	원주율을 계산하는 쓰레드와
	계산이 완료되면 계산된 원주율을 출력하는 쓰레드가 있다.
	
	이 문제를 해결하려면 원주율을 저장하는 객체가 필요하다.
	그리고 이 객체를 두 쓰레드에서 공통으로 사용해서 처리해야 한다.
	
*/
public class ThreadTest14 {

	public static void main(String[] args) {
		// 공통으로 사용할 객체 생성
		ShareData sd = new ShareData();
		
		// 쓰레드 객체를 생성하고 공통으로 사용할 객체를 쓰레드에 주입한다.
		CalcPIThread calc = new CalcPIThread(sd); // 생성자 이용
		
		PrintPIThread prn = new PrintPIThread();
		prn.setSd(sd);	// setter이용
		
		calc.start();
		prn.start();
		

	}

}

// 원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;  // 공통으로 사용할 객체의 참조값이 저장될 변수
	
	// 공통으로 사용할 객체변수 초기화하기
	// 생성자 이용하기
	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
	/*
	원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 -....) * 4
		
		1 - 3 + 5 - 7 + 9 -....
		
		0   1   2   3   4  
	*/
		double sum = 0.0;
		for(int i=1; i<100000000; i+=2) {
			if( (i/2) % 2 == 0) {  // 몫이 짝수일 때
				sum = sum + (1.0/i);
			}else {
				sum -= (1.0/i);
			}
		}
		
		sd.myPI = sum * 4;	// 계산 완료
		sd.isOk = true;
		
	}
}

// 계산된 원주율을 출력하는 쓰레드
class PrintPIThread extends Thread{
	private ShareData sd;  // 공통으로 사용할 객체의 참조값이 저장될 변수
	
	// 공통으로 사용할 객체변수 초기화하기
	// setter 이용하기
	public void setSd(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(true) {
			if(sd.isOk==true) {
				break;
			}else {
				Thread.yield();
			}
		}
		
		System.out.println();
		System.out.println("결과 : " + sd.myPI);
		System.out.println("PI : " + Math.PI);
		
	}
	
	
}



// 원주율을 관리하는 클래스 (공통으로 사용할 클래스)
class ShareData{
	public double myPI;  // 계산된 원주율이 저장될 변수
	
	public volatile boolean isOk = false;  // 계산이 완료되었는지를 나타내는 변수 
}
















