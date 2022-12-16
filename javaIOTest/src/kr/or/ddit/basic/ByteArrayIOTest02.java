package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; 	// 4개짜리 배열 생성
		
		ByteArrayInputStream input =
				new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output =
				new ByteArrayOutputStream();
		
		try {
			// 읽어올 데이터가 있는지 확인
			while(input.available()>0) {
//				input.read(temp);	// 입력 (배열 크기만큼씩 읽어온다.)
//				output.write(temp); // 출력 (배열 전체를 출력한다.)
				
				// read(배열변수) ==> 실제 읽어온 데이터 수를 반환한다.
				int len = input.read(temp);
				
				// temp배열의 데이터들 중 0번째부터 len개수만큼 출력한다.
				output.write(temp, 0, len);
				
				System.out.println("반복문 안에서 temp : " 
							+ Arrays.toString(temp));
			}
			
			outSrc = output.toByteArray();
			
			System.out.println();
			System.out.println(" inSrc => " + Arrays.toString(inSrc));
			System.out.println("outSrc => " + Arrays.toString(outSrc));
			System.out.println("  temp => " + Arrays.toString(temp));
			
			input.close();
			output.close();
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		

	}

}






