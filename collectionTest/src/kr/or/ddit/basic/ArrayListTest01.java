package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		// ArrayList는 기본적인 사용법이 Vector와 같다.
		
		ArrayList list1 = new ArrayList();
		
		// add()메서드로 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(false);
		list1.add(123.45);
		
		System.out.println("size => " + list1.size());
		System.out.println("list1 => " + list1);
		
		// get()메서드로 데이터를 꺼내온다.
		System.out.println("1번째 자료 : " + list1.get(1));

		// 데이터 끼워넣기도 같다.
		list1.add(3,"zzz");
		System.out.println("list1 => " + list1);
		
		// 데이터 변경하기
		String temp = (String)list1.set(3, "yyy");
		System.out.println("list1 => " + list1);
		System.out.println("temp => " + temp);
		
		// 삭제도 같다.
		list1.remove(3);
		System.out.println("list1 => " + list1);
		
		list1.remove("bbb");
		System.out.println("list1 => " + list1);
		
		System.out.println("---------------------------");
		// 제네릭을 사용할 수 있다.
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("BBBB");
		list2.add("EEEE");
		
		for(int i=0; i<list2.size(); i++) {
			System.out.println(i + " ==> " +list2.get(i));
		}
		
		System.out.println("-----------------------------");
		
		for(String str : list2) {
			System.out.println(str);
		}
		System.out.println("-----------------------------");
		
		// contains(비교객체)	==> 리스트에 '비교객체'가 있으면 true,
		//						없으면 false를 반환한다.
		System.out.println("DDDD값 : " + list2.contains("DDDD"));
		System.out.println("ZZZZ값 : " + list2.contains("ZZZZ"));
		System.out.println("--------------------------");
		// indexOf(비교객체)
		// lastIndexOf(비교객체)
		//	==> 리스트에 '비교객체'가 있으면 '비교객체'가 저장되어 있는 
		// 	index값을 반환하고 '비교객체'가 없으면 -1을 반환한다.
		
		// indexOf()는 앞에서부터 뒤쪽방향으로 검색하고
		// lastIndexOf()는 뒤에서 앞쪽방향으로 검색한다.
		System.out.println("1. BBBB 위치값 : " + list2.indexOf("BBBB"));
		System.out.println("2. BBBB 위치값 : " + list2.lastIndexOf("BBBB"));
		System.out.println("3. ZZZZ 위치값 : " + list2.indexOf("ZZZZ"));
		
		System.out.println("----------------------------");
		
		// toArray() ==> 리스트 안의 데이터를 배열로 변환하여 반환한다.
		//			==> 기본적으로 Object형 배열로 변환한다.
		
		// toArray(new 제네릭타입[0]);
		//		==> 제네릭 타입의 배열로 변환한다.
		
		
		Object[] strArr = list2.toArray();
//		String[] strArr = (String[])list2.toArray();
		// ==> 이런 방법으로는 변환이 안된다.
		
		System.out.println("배열의 개수 : " + strArr.length);
		for(int i=0; i<strArr.length; i++) {
			System.out.println(i + "번째 자료 : " + strArr[i]);
		}
		System.out.println("-------------------------------");
		
		String[] strArr2 = list2.toArray(new String[0]);
		for(String str : strArr2) {
			System.out.println(str);
		}
		
	}

}











