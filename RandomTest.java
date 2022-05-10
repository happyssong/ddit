package kr.or.ddit.test;

public class RandomTest {

	public static void main(String[] args) {
		
		
		//클래스 객체 생성
		RandomTest test = new RandomTest();
		test.randProc();		
	}

	
	public void randProc() {
		
		
		//주사위 던지기 - 랜덤 발생 1~6
		int rand = (int)(Math.random()*6+1);
		
		//비교
		/*if(rand == q) {
			
		}else if(rand == 1)
		를 6번 반복해야함. 스위치문으로 바꿔보자
		*/
		
		
		String str = "";
		switch(rand) {
		case 1:
			str = "사탕 1개";
			break;
		case 2:
			str = "사탕 2개";
			break;
		case 3:
			str = "사탕 3개";
			break;
		case 4:
			str = "사탕 4개";
			break;
		case 5:
			str = "사탕 5개";
			break;
		case 6:
			str = "사탕 6개";
			break;
		}
		
		
		//결과
		System.out.println("주사위 수 :" + rand +"\n");
		System.out.println("획득상품 :"+str);
		
	}
}
