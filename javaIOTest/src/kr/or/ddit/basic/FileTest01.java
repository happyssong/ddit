package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		// File객체 만들기 연습
		
		// 1. new File(String 파일 또는 경로)
		//	==> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의
		//		구분문자는 '\'를 사용하거나 '/'를 사용할 수 있다.
		//File file1 = new File("d:/d_other/test.txt"); // 구분문자로 '/' 사용
		File file1 = new File("d:\\d_other\\test.txt"); // 구분문자로 '\' 사용
		
		System.out.println("파일명 : " + file1.getName());
		System.out.println("디렉토리 여부 : " + file1.isDirectory());
		System.out.println("파일 여부 : " + file1.isFile());
		System.out.println();
		
		File file2 = new File("d:/d_other");
		System.out.println("파일명 : " + file2.getName());
		System.out.println("디렉토리 여부 : " + file2.isDirectory());
		System.out.println("파일 여부 : " + file2.isFile());
		System.out.println();
		
		
		// 2. new File(File parent, String child)
		//	==> 'parent'디렉토리 안에 있는 'child'파일 갖는 File객체 생성
		File file3 = new File(file2, "test.txt");
		System.out.println("파일명 : " + file3.getName());
		System.out.println("디렉토리 여부 : " + file3.isDirectory());
		System.out.println("파일 여부 : " + file3.isFile());
		System.out.println();
		
		// 3. new File(String parent, String child)
		File file4 = new File("d:/d_other", "test.txt");
		System.out.println("파일명 : " + file4.getName());
		System.out.println("디렉토리 여부 : " + file4.isDirectory());
		System.out.println("파일 여부 : " + file4.isFile());
		System.out.println();
		
		File file5 = new File("d:/d_other/temp.txt");
		System.out.println("파일명 : " + file5.getName());
		System.out.println("디렉토리 여부 : " + file5.isDirectory());
		System.out.println("파일 여부 : " + file5.isFile());
		System.out.println();
		
		
		// 폴더(디렉토리) 만들기
		/*
		- mkdir() ==> File객체의 경로 중 마지막 위치의 디렉토리를 생성한다.
			반환값 ==> 만들기 성공(true), 실패(false)
			==> 중간 부분의 경로가 모두 만들어져 있어야 마지막 위치의 폴더를
				만들수 있다.
		- mkdirs() ==> 중간 부분의 경로가 없으면 중간 부분의 경로도 같이 만들어 준다.
		*/
		File file6 = new File("d:/d_other/연습용");
		System.out.println(file6.getName() + "의 존재 여부 : " 
					+ file6.exists());
		
		if(!file6.exists()) {
			if(file6.mkdir()) {
				System.out.println(file6.getName() + "만들기 성공!!");
			}else {
				System.out.println(file6.getName() + "만들기 실패~~");
			}
		}
		System.out.println();
		
		File file7 = new File("d:/d_other/test/java/src");
		if(!file7.exists()) {
			
			if(file7.mkdirs()) {
				System.out.println(file7.getName() + "만들기 성공");
			}else {
				System.out.println(file7.getName() + "만들기 실패~");
			}
			
			
		}
		
		
		
		
		
		
	}

}











