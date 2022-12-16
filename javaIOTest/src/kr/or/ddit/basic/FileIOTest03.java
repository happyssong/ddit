package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {

	public static void main(String[] args) {
		// 문자 기반의 스트림을 이용하여 파일 내용 읽어와 출력하기
		try {
			// 문자기반의 입력용 스트림 객체 생성
			FileReader fr = new FileReader("d:/d_other/test.txt");
			
			int c;
			
			while((c=fr.read()) != -1) {
				System.out.print((char) c);
			}
			
			fr.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
