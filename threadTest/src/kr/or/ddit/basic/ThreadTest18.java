package kr.or.ddit.basic;

/*
	wait(), notify()를 이용한 두 쓰레드에서 
	번갈아 한번씩 실행하는 예제
	
	wait(), notify, notifyAll()은 동기화 영역에서만 사용 가능하다.
*/
public class ThreadTest18 {

	public static void main(String[] args) {
		WorkObject work = new WorkObject();
		
		
		ThreadA th1 = new ThreadA(work);
		ThreadB th2 = new ThreadB(work);
		
		th1.start();
		th2.start();

	}

}

// 공통으로 사용할 객체
class WorkObject{
	public synchronized void testMethod1() {
		System.out.println("testMethod1()메서드 실행중...");
		
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void testMethod2() {
		System.out.println("testMethod2()메서드 실행중...");
		
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

// WorkObject의 testMethod1()메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workObj;
	
	// 생성자
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObj.testMethod1();
		}
		
		synchronized (workObj) {
			workObj.notify();
		}
		
	}
	
}


//WorkObject의 testMethod2()메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workObj;
	
	// 생성자
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObj.testMethod2();
		}
		
		synchronized (workObj) {
			workObj.notify();
		}
		
	}
	
}















