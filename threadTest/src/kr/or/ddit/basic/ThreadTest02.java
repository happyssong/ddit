package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		//	멀티 쓰레드 프로그램
		//	'*'문자를 200개 출력하는 부분과 '$'문자를 200개 
		//	출력하는 프로그램을 작성하려고 한다.

		// Thread를 작성하고 사용하는 방법
		
		// 방법1
		// Thread클래스를 상속한 class를 작성한 후 이 class의
		// 인스턴스를 생성한 후 이 인스턴스의 start()메서드를 호출해서 실행한다.
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		// 방법2
		// Runnable인터페이스를 구현한 class를 작성한 후 이 class의
		// 인스턴스를 생성한다. 그리고 생성된 이 class의 인스턴스를
		// Thread의 인스턴스를 생성할 때 생성자에 인수값으로 넣어서
		// 생성한 후 이 Thread의 인스턴스의 start()메서드를 호출해서 실행한다.
		Runnable r1 = new MyRunner();
		Thread th2 = new Thread(r1);
		th2.start();
		
		// 방법3 
		// Runnable인터페이스의 익명 구현체를 이용하는 방법
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<=200; i++) {
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
			}
		};
		
		Thread th3 = new Thread(r2);
		th3.start();
		
		
		
		System.out.println("main()메서드 끝...");
	}

}

// 방법1 - Thread클래스를 상속한 class작성하기
class MyThread1 extends Thread{
	@Override
	public void run() {
		// 이 run()메서드 안에는 쓰레드에서 처리할 내용을 기술한다.
		for(int i=1;i<=200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간) ==> 주어진 '시간'동안 작업을 잠시 멈춘다.
				// '시간'은 밀리세컨드 단위를 사용한다.
				// 즉, 1000은 1초를 의미한다.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

// 방법2 - Runnable인터페이스를 구현한 class작성하기
class MyRunner implements Runnable{
	@Override
	public void run() {
		for(int i=1; i<=200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

























