package kr.or.ddit.test;
	import java.util.Scanner;
	
public class LogintTest {


	public static void main(String[] args) {
		
		 LogintTest log = new  LogintTest();
		 log.loginProc();
	
	
	}

	
	public void loginProc() {
		
		//�Է�
		Scanner sc = new Scanner(System.in);
	
		//���̵�� ��й�ȣ
		System.out.println("���̵� �Է� : ");
		String id = sc.nextLine(); 
		
		System.out.println("��й�ȣ �Է� : ");
		String pass = sc.nextLine(); //���� ���·θ� �Է�
	
		String res = "";
		int pw = Integer.parseInt(pass);
		
		//�� - pass�� ���ڷ� ��
		if("java".equals(id)) {
			if(pw == 1234){
				res = "�α��� ����";	
				
			}else{
				res = "�α��ν���-�н����� ����";
			}
			
		}else {
			res = "�α��ν���-���̵� �������� ����";
			
		}
		
		//���
		String str = "�Է� id =	" +id +"\n";
		str += "�Է� pw=	" +pw +"\n";
		str += "��� :	" +res;
		System.out.println(str);
		
	}
	
	
}


