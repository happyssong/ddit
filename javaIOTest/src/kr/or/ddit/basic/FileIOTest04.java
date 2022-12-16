package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest04 {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 저장하기
		
		try {
			// Scanner scan = new Scanner(System.in);
			// System.out.println()
			
			// System.in ==> 콘솔(표준 입출력장치)의 입력장치
			//		==> 바이트 기반의 입력용 스트림 객체가 저장되어 있다.
			
			// System.out ==> 콘솔의 출력장치
			//		==> 바이트 기반의 출력용 스트림 객체가 저장되어 있다.
			
			// 입력용 바이트 기반의 스트림을 문자 기반의 스트림으로 변환해 주는
			// 보조 스트림을 이용한다.
			InputStreamReader isr = 
					new InputStreamReader(System.in);
			
			// 파일 출력용 스트림 객체 생성 
			FileWriter fw = 
				new FileWriter("d:/d_other/testChar.txt");
			
			System.out.println("아무 내용이나 입력하세요.");
			System.out.println("(입력의 끝은 'Ctrl + z' 입니다.)");
			
			int c;
			
			// 콘솔에서 입력할 때 입력의 끝은 'Ctrl+Z'키를 누르면 된다.
			while((c=isr.read())!=-1) {
				fw.write(c);	// 콘솔로 입력받은 데이터를 파일에 출력한다.
			}
			
			// 스트림 닫기
			isr.close();
			fw.close();
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		

	}

}
