package kr.or.ddit.test;
	import java.util.Scanner;
	
public class LogintTest {


	public static void main(String[] args) {
		
		 LogintTest log = new  LogintTest();
		 log.loginProc();
	
	
	}

	
	public void loginProc() {
		
		//입력
		Scanner sc = new Scanner(System.in);
	
		//아이디와 비밀번호
		System.out.println("아이디 입력 : ");
		String id = sc.nextLine(); 
		
		System.out.println("비밀번호 입력 : ");
		String pass = sc.nextLine(); //숫자 형태로만 입력
	
		String res = "";
		int pw = Integer.parseInt(pass);
		
		//비교 - pass는 숫자로 비교
		if("java".equals(id)) {
			if(pw == 1234){
				res = "로그인 성공";	
				
			}else{
				res = "로그인실패-패스워드 오류";
			}
			
		}else {
			res = "로그인실패-아이디 존재하지 않음";
			
		}
		
		//출력
		String str = "입력 id =	" +id +"\n";
		str += "입력 pw=	" +pw +"\n";
		str += "결과 :	" +res;
		System.out.println(str);
		
	}
	
	
}


