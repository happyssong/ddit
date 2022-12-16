package kr.or.ddit.basic.generic;


class NonGeneric{
	private Object value;
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
}

/*
	제네릭 클래스 만드는 방법
	형식)
	class 클래스명<제네릭타입문자>{
		제네릭타입문자 변수명;		// 변수 선언에 제네릭 사용하는 경우
		...
		
		제네릭타입문자 메서드명(){  // 반환값이 있는 메서드에서 사용하는 경우
			...
			return 반환값;
		}
		
		// 메서드의 매개변수에 사용하는 경우
		반환값타입 메서드명(제네릭타입문자 변수명1, ....){
			...
			return 반환값
		}
	}

	- 제네릭타입문자는 보통 영문자 대문자를 1글자 사용한다.
	- 많이 사용되는 제네릭타입문자
	  T  ==> Type
	  K  ==> Key
	  V  ==> Value
	  E	 ==> Element

*/

class MyGeneric<T>{
	private T value;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
}


public class GenericTest {

	public static void main(String[] args) {
		NonGeneric non1 = new NonGeneric();
		non1.setValue("가나다라");
		
		NonGeneric non2 = new NonGeneric();
		non2.setValue(100);
		
		String strTemp = (String)non1.getValue();
		System.out.println("문자열 반환값 : " + strTemp);
		
		Integer intTemp = (Integer)non2.getValue();
		int intTemp2 = (int)non2.getValue();
		System.out.println("정수형 반환값1 : " + intTemp);
		System.out.println("정수형 반환값2 : " + intTemp2);
		System.out.println("--------------------------");
		
		MyGeneric<String> mg1 = new MyGeneric<String>();
		mg1.setValue("우리나라");
		// 제네릭에 지정한 자료형이 아닌 데이터를 사용하면 오류가 된다.
		//mg1.setValue(200);
		
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		mg2.setValue(500);
		//mg2.setValue("가나다라"); // 오류
		
		String temp = mg1.getValue();  // 형변환 불필요
		int itemp = mg2.getValue();
		System.out.println("제네릭 문자열 반환값 : " + temp);
		System.out.println("제네릭 정수형 반환값 : " + itemp);
		System.out.println("---------------------------");
		
		NonGeneric non3 = new NonGeneric();
		non3.setValue("대한민국");
		
		Integer v = (Integer)non3.getValue();
		
		System.out.println("v = " + v);
		
		

	}

}







