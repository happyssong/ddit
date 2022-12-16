package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	문제) 'd:/d_other'폴더에 저장되어 있는 '펭귄.jpg'파일을
		'd:/d_other/연습용'폴더에 '복사본_펭귄.jpg'파일로 복사하는
		프로그램을 작성하시오.
*/
public class FileCopy {

	public static void main(String[] args) {
		File file = new File("d:/d_other/펭귄.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getName() + "파일이 없습니다.");
			System.out.println("복사 작업을 중단합니다.");
			return;
		}
		
		try {
			// 원본 파일을 읽어올 스트림 객체 생성
			FileInputStream fin = new FileInputStream(file);
			BufferedInputStream bin = 
					new BufferedInputStream(fin);
			
			// 대상 파일에 출력할 스트림 객체 생성
			FileOutputStream fout = 
				new FileOutputStream("d:/d_other/연습용/복사본_펭귄.jpg");
			BufferedOutputStream bout =
				new BufferedOutputStream(fout);
			
			
			System.out.println("복사 시작...");
			
// ----------------------------------------------------			
//			int data;  // 읽어온 데이터를 저장할 변수
//			
//			while((data=fin.read())!=-1) {
//				fout.write(data);
//			}
// ----------------------------------------------------

// ----------------------------------------------------
//			byte[] temp = new byte[1024];
//			int len = 0;
//			while((len=fin.read(temp))>0) {
//				fout.write(temp, 0, len);
//			}
//			fout.flush();
// ----------------------------------------------------
			
			byte[] temp = new byte[1024];
			int len = 0;
			while((len=bin.read(temp))>0) {
				bout.write(temp, 0, len);
			}
			bout.flush();
			
			
			// 스트림 닫기
//			fout.close();
//			fin.close();
			bout.close();
			bin.close();
			
			System.out.println("복사 작업 완료...");
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}















