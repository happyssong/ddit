package kr.or.ddit.basic.singleton;

/*
	singleton패턴 ==> 객체가 1개만 만들어지게 하는 방법
			(외부에서 new 명령을 사용하지 못하게 한다.)
	- 사용 목적 : 1. 메모리 낭비를 방지한다.
				2. 데이터의 공유가 쉽다.
	
	- singleton 클래스를 만드는 방법 (필수 구성 요소)
	1. 자신 class의 참조값이 저장될 변수를 private static을 선언한다.
	
	2. 모든 생성자의 접근제한자를 private으로 한다. ( 외부에서 new명령을 사용하지 못하게 하기 위해서... )
		(기본 생성자만 있더라도 반드시 생성자를 작성해야 한다. )
	
	3. 자신 class의 인스턴스를 생성하고 반환하는 메서드를 public static으로 작성한다.
		(이 메서드의 이름은 보통 getInstance로 한다. )
	
	
*/
public class MySingleton {
	// 1번
	private static MySingleton single;
	
	// 2번
	private MySingleton() {
		System.out.println("생성자 입니다...");
	}
	
	// 3번
	public static MySingleton getInstance() {
		// 1번에서 선언한 변수가 null이면 객체를 생성해서 1번에서 선언한 변수에 저장한다.
		if(single==null) single = new MySingleton();
		
		return single;
	}
	
	// 기타 이 클래스가 처리할 내용을 기술한다.
	public void test() {
		System.out.println("이것은 싱글톤 객체의 메서드 실행입니다...");
	}

}










