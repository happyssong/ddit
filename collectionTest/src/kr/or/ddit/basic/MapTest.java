package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
	/*
	- Map ==> key값과 value값을 한 쌍으로 관리하는 객체
	 	- key값은 중복을 허용하지 않고 순서가 없다.(Set의 특징을 갖는다.)
	 	- value값은 중복을 허용한다.
	*/
		// Map객체 생성
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 ==> put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map => " + map);
		
		// 자료 수정 ==> 데이터를 추가할 때 key값이 같으면 나중에 입력한 값이 저장된다.
		map.put("addr", "서울");
		System.out.println("map => " + map);
		System.out.println();
		
		// 자료 읽기 ==> get(key값)
		//		==> key값과 짝이 되는 value값을 반환한다.
		//		==> 해당 key값이 없으면 null을 반환한다.
		System.out.println("이름 : " + map.get("name"));
		System.out.println();
		
		/*
		// 자료 삭제 ==> remove(key값)
		//		==> key값이 같은 자료를 찾아서 삭제한다.
		//		==> 반환값 : 삭제된 자료의 value값
		String temp = map.remove("tel");
		System.out.println("map => " + map);
		System.out.println("삭제된 값 : " + temp);
		System.out.println();
		*/
		
		// key값이 존재하는지 여부 검사하는 메서드 ==> containsKey(key값)
		// 		==> 해당 key값이 존재하면 true, 그렇지 않으면 false 반환
		System.out.println("tel 키값 존재 여부 : " 
								+ map.containsKey("tel"));
		System.out.println("age 키값 존재 여부 : " 
								+ map.containsKey("age"));
		System.out.println();
		System.out.println("-------------------------------");
		
		// Map의 모든 데이터를 차례로 읽어와 사용하는 방법
		
		// 1. Map의 모든 key값을 읽어와서 사용하는 방법
		
		// 방법1) keySet()메서드 이용하기
		//		==> Map의 모든 key값들을 읽어와 Set형으로 반환한다.
		Set<String> keySet = map.keySet();
		
		// 방법1-1) Iterator이용
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("--------------------------------");
		
		// 방법1-2) 향상된 for문 사용
		for(String key : keySet) {
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("--------------------------------");
		
		// 방법2) values()메서드 사용하기
		//		==> value값만 읽어와서 처리한다.
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("--------------------------------");
		
		//-----------------------------------------------------
		//  Map에는 Entry라는 내부 class가 만들어져 있다.
		// 	이 Entry클래스는 key와 value라는 이름의 멤버변수로 구성되어 있다.
		//	Map에서는 이 Entry객체들을 Set형식으로 저장하여 관리한다.
		//-----------------------------------------------------
		
		// 방법3) Entry객체 전체를 가져와서 처리한다.
		//		entrySet()메서드 사용 ==> 모든 Entry객들을 가져와
		//					Set형식으로 반환한다.
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> entryIt 
										= mapSet.iterator();
		
		while(entryIt.hasNext()) {
			// 1개의 Entry객체 구하기
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.println("key값 : " + entry.getKey());
			System.out.println("value값 : " + entry.getValue());
			System.out.println();
		}
		System.out.println("--------------------------------");
				
				
		
		
		
		
	}

}















