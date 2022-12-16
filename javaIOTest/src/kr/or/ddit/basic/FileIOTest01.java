package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {

	public static void main(String[] args) {
		// 파일 내용을 바이트 기반의 스트림으로 읽어와 화면에 출력하는 예제
		// ==> FileInputStream객체 이용
		try {
			
			// 읽어올 파일 정보를 인수값으로 받는 FileInputStream객체 생성
			
			// 방법1 ==> 파일 정보를 문자열로 지정하는 방법
			FileInputStream fin = 
					new FileInputStream("d:/d_other/test.txt");
			
			// 방법2 ==> 파일 정보를 File객체로 지정하는 방법
//			File f = new File("d:/d_other/test.txt");
//			FileInputStream fin = new FileInputStream(f);
			
			int c; 	// 읽어온 데이터를 저장할 변수
			while((c=fin.read()) != -1) {  // 읽기
				System.out.print( (char)c );  // 화면에 출력
			}
			
			fin.close();		// 스트림 닫기
			
		} catch (IOException e) {
			System.out.println("입출력 오류입니다. => " + e.getMessage());
		}

	}

}







