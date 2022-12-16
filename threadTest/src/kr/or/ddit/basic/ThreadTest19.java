package kr.or.ddit.basic;

public class ThreadTest19 {

	public static void main(String[] args) {
		DataBox  box = new DataBox();
		
		ProducerThread th1 = new ProducerThread(box);
		ConsumerThread th2 = new ConsumerThread(box);
		
		th1.start();
		th2.start();

	}

}

// 데이터를 공통으로 사용하는 클래스
class DataBox{
	private String data;
	
	// data변수 값이 null이면 data변수에 문자열이 저장될 때까지 기다리고
	// data변수에 값이 있으면 해당 문자열을 반환한다.
	// 반환 후에는 data변수 값을 null로 변경한다.
	public synchronized String getData() {
		if(data==null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		String temp = data;  
		System.out.println("쓰레드에서 읽은 데이터 : " + data);
		
		data = null;
		
		notify();
		
		return temp;
		
	}
	
	
	// data변수에 값이 있으면 data변수 값이 null이 될 때까지 기다린다.
	// data변수가 null이되면 새로운 data값을 저장한다.
	public synchronized void setData(String data) {
		if(this.data!=null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		this.data = data;
		System.out.println("Thread에서 새로 저장한 데이터 : " + data);
		
		notify();
		
	}
}

// 데이터를 넣어주는 쓰레드 (공급용 쓰레드)
class ProducerThread extends Thread{
	private DataBox databox;
	
	public ProducerThread(DataBox databox) {
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			databox.setData("공급 데이터 " + i);
		}
	}
}


// 데이터를 꺼내서 사용하는 쓰레드
class ConsumerThread extends Thread{
	private DataBox databox;
	
	public ConsumerThread(DataBox databox) {
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			String result = databox.getData();
		}
	}
	
	
}


















