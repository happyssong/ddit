package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class EqualsHashcodeTest {

	public static void main(String[] args) {
		int a = 0;
		
		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setNum(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		System.out.println("-------------------------------");
		
		HashSet<Person> testSet = new HashSet<Person>();
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("set의 크기 : " + testSet.size());
		
		System.out.println("p1 : " + p1.hashCode() );
		System.out.println("p2 : " + p2.hashCode() );
		System.out.println("p3 : " + p3.hashCode() );
		
		/*
		- equals()메서드 ==> 두 객체의 내용이 같은지 검사하는 메서드
		- hashCode()메서드 ==> 두 객체의 동일성을 검사하는 메서드
		
		- HashSet, Hashtable, HashMap과 같이 Hash로 시작하는 
		  컬렉션객체들은 객체의 의미상 동일성을 비교하기 위해서 hashCode()
		  메서드를 호출하여 비교한다.
		  그러므로, 객체가 같은지 여부를 결정하려면 hashCode()메서드를
		  재정의 해야한다.
		  
		- hashCode()메서드에서 사용하는 '해싱 알고리즘'은 서로 다른 객체들에
		  대해서 같은 hashcode가 나타날 수 있다.
		*/
		
		System.out.println();
		System.out.println("------------------------------");
		// 이름을 key값으로 사용하고 Person의 인스턴스를 value값으로
		// 사용하는 Map객체를 생성하시오.
		HashMap<String, Person> testMap 
					= new HashMap<String, Person>();
		
		testMap.put("홍길동", p1);
		
		Person p4 = new Person();
		p4.setNum(10);
		p4.setName("이순신");
		
		testMap.put("이순신", p4);
		
		testMap.put("강감찬", new Person());
		testMap.put("이몽룡", new Person(11, "이몽룡"));
		
		// 이몽룡 정보 출력하기
		Person p5 = testMap.get("이몽룡");
		System.out.println("번호 : " + p5.getNum());
		System.out.println("이름 : " + p5.getName());
		System.out.println("---------------------------");
		
		// 강감찬의 정보를 번호는 30, 이름은 "강감찬"으로 셋팅하시오.
		
		// 방법1 ==> 같은 key값으로 새로운 데이터를 만들어 저장한다.
		//testMap.put("강감찬", new Person(30, "강감찬"));
		
		Person p6 = testMap.get("강감찬");
		System.out.println("번호 : " + p6.getNum());
		System.out.println("이름 : " + p6.getName());
		System.out.println("---------------------------");
		
		p6.setNum(30);
		p6.setName("강감찬");
		
		Person p7 = testMap.get("강감찬");
		System.out.println("번호 : " + p7.getNum());
		System.out.println("이름 : " + p7.getName());
		
		
		
		
	}

}


class Person{
	private int num;
	private String name;
	
	// 기본 생성자
	public Person() { }
	
	// 생성자
	public Person(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		
		// 참조값이 같은지 검사
		if(this==obj) return true;
		
		// 같은 종류의 class인지 검사
		if(this.getClass() != obj.getClass() )
			return false;
		
		// 매개변수의 값을 현재 객체 유형으로 형변환한다.
		Person that = (Person)obj;
		
		if(this.name==null && that.name != null) {
			return false;
		}
		
		if(this.num==that.num && this.name==that.name) {
			return true;
		}
		
		if(this.num==that.num && this.name.equals(that.name)) {
			return true;
		}
		
		return false;
		
	}
	*/
	
	
	
	
}


