package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
	문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
		컴퓨터의 숫자는 난수를 이용하여 구한다.
		(스트라이크는 S, 볼은 B로 나타낸다.)
		
	예시) 컴퓨터의 난수 ==> 9 5 7
	
	실행예시)
		숫자입력 => 3 5 6 
		3 5 6 => 1S 0B
		숫자입력 => 7 8 9
		7 8 9 => 0S 2B
		숫자입력 => 9 7 5
		9 7 5 => 1S 2B
		숫자입력 => 9 5 7
		9 5 7 => 3S 0B
		
		축하합니다.
		당신은 4번째만에 맞췄습니다.
	
*/


public class BaseBallTest {
	private ArrayList<Integer> numList; // 컴퓨터의 난수를 저장할 List
	private ArrayList<Integer> userList; // 사용자가 입력한 값을 저장할 List
	
	private int strike;	// 스트라이크 개수
	private int ball;	// 볼의 개수
	
	Scanner scan = new Scanner(System.in);
	
	// 1 ~ 9사이의 서로 다른 난수 3개를 만들어서 List에 저장하는 메서드
	// 난수는 중복되지 않아야 된다. (Set 이용)
	private void getNum() {
		Set<Integer> numSet = new HashSet<Integer>();
		
		// 1 ~ 9사이의 서로 다른 난수 3개 만들기
		while(numSet.size()<3) {
			numSet.add((int)(Math.random() * 9 + 1));
		}
		
		// 만들어진 난수를 List에 저장하기
		numList = new ArrayList<Integer>(numSet);
		
		// List의 데이터를 섞어준다.
		Collections.shuffle(numList);
	}
	
	
	// 사용자로부터 3개의 정수를 입력받아서 List에 저장하는 메서드
	// 입력한 값은 중복되지 않아야 된다.
	private void inputData() {
		int n1, n2, n3; 	// 입력한 정수가 저장될 변수 선언
		
		do {
			System.out.print("숫자입력 => ");
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();
			if(n1==n2 || n1==n3 || n2==n3) {
				System.out.println("중복되는 숫자는 입력 불가. 다시입력하세요.");
			}
		}while(n1==n2 || n1==n3 || n2==n3);
		
		// 입력받은 데이터들을 List에 추가한다.
		userList = new ArrayList<Integer>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
	}
	
	// 스트라이크와 볼의 개수를 구한 후 출력하는 메서드
	private void printBallCount() {
		strike = 0; 	// 스트라이크 개수와 볼의 개수 초기화
		ball = 0;
		
		for(int i=0; i<userList.size(); i++) {
			for(int j=0; j<numList.size(); j++) {
				
				// 값이 같은지 검사
				if(userList.get(i) == numList.get(j)) {
					if(i==j) {  // 위치가 같은지 검사
						strike++;
					}else {
						ball++;
					}
				}
			}
		}
		
		// 결과를 출력한다.
		System.out.println(userList.get(0) + " " +
					userList.get(1) + " " +
					userList.get(2) + " => " +
					strike + "S " + ball + "B");
		
	}
	
	// 게임 시작 메서드
	public void gameStart() {
		getNum();  // 난수 만들기
		
		//System.out.println("만들어진 난수 : " + numList);
		
		int cnt = 0; // 몇번만에 맞췄는지 여부를 저장하는 변수
		do {
			cnt++;
			inputData();  // 사용자 입력
			
			// 볼카운트 처리하기
			printBallCount();
			
		}while(strike!=3);  // 3스트라이크 될때까지 반복...
		
		System.out.println();
		System.out.println("축하합니다.");
		System.out.println("당신은 " + cnt + "번째만에 맞췄습니다.");
		
	}
	

	public static void main(String[] args) {
		new BaseBallTest().gameStart();
	}

}














