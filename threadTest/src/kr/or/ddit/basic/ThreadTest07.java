package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	
	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
	사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력 받는다.
	
	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
	5초안에 입력이 없으면 게임에 진것으로 처리한다.
	
	5초안에 입력이 있으면 승패를 구해서 출력한다.

	----------------------------------------
	실행예시)  --> 5초안에 입력을 못했을 경우
	 -- 결 과 --
	 시간초과로 당신이 졌습니다.
	
	실행예시)  --> 5초안에 입력을 했을 경우
	 -- 결 과 --
	 컴퓨터 : 가위
	 사용자 : 바위
	 결 과 : 당신이 이겼습니다. 
	  


*/
public class ThreadTest07 {
	public static boolean inputCheck;
	
	public static void main(String[] args) {
		GameTimer gt = new GameTimer();
		
		// 컴퓨터의 가위 바위 보는 난수를 이용해서 정하기
		String[] data = {"가위", "바위", "보"};
		int index = (int)(Math.random() * 3 );  // 0 ~ 2사이의 난수 만들기
		String com = data[index];
		
		// 사용자의 가위 바위 보 입력 받기
		
		gt.start();		// 카운트 다운 시작
		
		String man = null;
		
		do {
			man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
		//}while( !("가위".equals(man) || "바위".equals(man) || "보".equals(man)));
		}while( (!"가위".equals(man) && !"바위".equals(man) && !"보".equals(man)));
		
		inputCheck = true;
		
		// 결과 판정하기
		String result = ""; 	// 결과가 저장될 변수
		
		/*
		if(com.equals(man)) {
			result = "비겼습니다.";
		}else if( com.equals("가위") && man.equals("보") 
				|| com.equals("바위") && man.equals("가위")
				|| com.equals("보") && man.equals("바위")) {
			result = "당신이 졌습니다.";
		}else {
			result = "당신이 이겼습니다.";
		}
		*/
		switch(com + man) {
			case "가위가위":
			case "바위바위":
			case "보보": result = "비겼습니다."; break;
			
			case "가위보":
			case "바위가위":
			case "보바위": result = "당신이 졌습니다."; break;
			
			default : result = "당신이 이겼습니다.";
		}
		
		// 결과 출력하기
		System.out.println(" -- 결 과 --");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + man);
		System.out.println("결 과 : " + result);

	}

}

class GameTimer extends Thread{
	@Override
	public void run() {
		System.out.println("카운트 다운 시작...");
		for(int i=15; i>=1; i--) {
			
			// 입력 완료 여부 확인
			if(ThreadTest07.inputCheck) {
				return;
			}
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("-- 결 과 --");
		System.out.println("시간초과로 당신이 졌습니다.");
		System.exit(0);
		
	}
}












