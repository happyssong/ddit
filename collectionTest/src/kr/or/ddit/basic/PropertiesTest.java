package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {
/*	
	- Properties객체는 Map보다 축소된 기능의 객체라고 할 수 있다.
	
	- Map은 key값과 value값에 모든 종류의 객체를 사용할 수 있지만
	  Properties는 key값과 value값에 String만 사용할 수 있다.
	
	- Map은 put(), get() 메서드를 사용해서 입출력을 하지만
	  Properties는 setProperty(), getProperty()메서드를 통해서
	  입출력한다.
	  
	- Properties는 데이터를 파일로 입출력 할 수 있다.
	
*/
	public static void main(String[] args) {
		// 객체 생성
		Properties prop = new Properties();
		
		int age = 20;
		prop.setProperty("name", "홍길동");
		prop.setProperty("age1", "20");
		prop.setProperty("age2", age + "");
		prop.setProperty("age3", String.valueOf(age));
		prop.setProperty("tel", "010-1234-5678");
		prop.setProperty("addr", "대전");
		
		//---------------------------------------
		String name = prop.getProperty("name");
		int getAge = Integer.parseInt( prop.getProperty("age1") );
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + getAge);
		System.out.println("전화 : " + tel);
		System.out.println("주소 : " + addr);
		
		
		

	}

}










