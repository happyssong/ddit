package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		// Buffered 스트림 사용 연습
		try {
			FileOutputStream fout =
				new FileOutputStream("d:/d_other/bufferTest.txt");
			
			// Buffered스트림 객체 생성
			// 버퍼의 크기를 지정하지 않으면 기본 크기가 8KB(8192byte)이다.
			BufferedOutputStream bout =
				new BufferedOutputStream(fout, 5);
			
			for(char c='1'; c<='9'; c++) {
				bout.write(c);
			}
			bout.flush();  // 작업을 종료하기 전에 버퍼에 남아있는
			//		데이터를 강제적으로 모두 출력시킨다.
			
			bout.close();
			
			System.out.println("출력 작업 끝...");
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
