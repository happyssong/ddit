package kr.or.ddit.loop;

public class WhileTest1 {

	public static void main(String[] args) {
		System.out.println("for-----------");
		//1~10까지 출력
		for(int i= 1; i<=10; i++){
			System.out.println(i);
		}//for문 끝나면 i사라짐, 밑에서 다시 선언 가능
		
		System.out.println("while========");
		int i =1;
		while(i <=10 ){
			System.out.println(i);
			i++;
			}
		}

}