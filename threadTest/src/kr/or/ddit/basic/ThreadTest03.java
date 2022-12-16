package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// 쓰레드가 수행되는 시간 체크해 보기
		
//		MyRunner2 r = new MyRunner2();
//		Thread th = new Thread(r);
		
		Thread th = new Thread(new MyRunner2());
		
		// 1970년 1월1일 0시0분0초(표준시간)로 부터 경과한 시간을
		// 밀리세컨드(1/1000)단위로 반환한다.
		// 3000 ==> 1970년 1월1일 0시0분3초
		long startTime = System.currentTimeMillis();
		
		th.start();  // 쓰레드 실행
		
		try {
			th.join(); // 현재 실행중인 쓰레드에서 
					// 대상이 되는 쓰레드(여기서는 변수 th)가 끝날때까지 
					// 기다린다.
		}catch(InterruptedException e) { }
		
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (endTime - startTime));
		

	}

}

class MyRunner2 implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for(long i=1L; i<=1_000_000_000L; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
}










