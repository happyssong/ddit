package kr.or.ddit.basic;

// 쓰레드의 상태를 출력하는 예제

public class ThreadTest09 {

	public static void main(String[] args) {
		StatePrintThread th = 
			new StatePrintThread(new TargetThread());
		
		th.start();

	}

}

// 쓰레드 상태의 검사 대상이 되는 쓰레드 만들기
class TargetThread extends Thread{
	@Override	
	public void run() {
		
		for(long i=1L; i<=20000000000L; i++) { } // 시간 지연용
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		for(long i=1L; i<=20000000000L; i++) { } // 시간 지연용
		
	}
}


// TargetThread의 상태를 확인해서 출력하는 쓰레드
class StatePrintThread extends Thread{
	// 쓰레드의 상태를 출력할 대상 쓰레드가 저장될 객체변수 선언
	private TargetThread target;
	
	// 생성자
	public StatePrintThread(TargetThread target) {
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true) {
			// 대상 쓰레드의 상태값 구하기 ==> getState()메서드 이용
			Thread.State state = target.getState();
			
			// 상태값 출력
			System.out.println("TargetThread의 상태값 : " + state);
			
			// 쓰레드의 상태값을 비교한다.
			if(state == Thread.State.NEW) { // NEW상태인지 여부 검사
				target.start();		// 대상 쓰레드 작동시키기
			}
			
			if(state == Thread.State.TERMINATED) { // 종료상태 여부 검사
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			
		}
	}
	
}
















