package kr.or.ddit.loop;

public class WhileTest6 {

	public static void main(String[] args) {
		
		//1~100 랜덤 5개를 발생하여 합을 구하여라
		
		int i = 1;
		int sum =0;
		int a;
		String rend =  "";
		while(i<=5) {
			a=(int)(Math.random()*100+1);
			sum+=a;
			rend=a+" ";
			System.out.print(rend);
			i++;
		}
		System.out.println("합계 : " +sum);
			

	}

}
