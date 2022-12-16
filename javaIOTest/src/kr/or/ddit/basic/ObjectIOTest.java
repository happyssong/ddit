package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {

	public static void main(String[] args) {
		// Member의 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("홍길서", 30, "서울");
		Member mem3 = new Member("홍길남", 40, "인천");
		Member mem4 = new Member("홍길북", 50, "울산");
		
		try {
			// 객체를 파일에 저장하기
			
			// 출력용 스트림 객체 생성
			FileOutputStream fout = 
				new FileOutputStream("d:/d_other/memObj.dat");
			BufferedOutputStream bout =
				new BufferedOutputStream(fout);
			ObjectOutputStream oout =
				new ObjectOutputStream(bout);
			
			// 쓰기 작업 
			System.out.println("객체 저장하기 시작...");
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);
			
			// EOFException 발생을 방지할 목적으로 null을 추가한다.
			oout.writeObject(null); 
			System.out.println("객체 저장하기 끝...");
			
			oout.close();  // 스트림 닫기

		} catch (IOException e) {
			e.printStackTrace();
		}
		
//-------------------------------------------------------
		// 저장된 객체를 읽어와 그 내용을 화면에 출력하기
		try {
			// 입력용 스트림 객체 생성
			ObjectInputStream oin =
				new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream("d:/d_other/memObj.dat")
					)
				);
			
			Object obj;  // 읽어온 객체를 저장할 변수
			
			System.out.println("객체 읽기 작업 시작...");
			
			
			// readObject()메서드가 데이터를 끝까지 다 읽어오면
			// EOFException을 발생한다.
			while((obj = oin.readObject())!=null) {
				Member mem = (Member) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("-----------------------");
			}
			
		} catch(EOFException e) {
			System.out.println("읽기 완료...");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch( Exception e) {
			e.printStackTrace();
		}

	}

}

class Member implements Serializable{
	private static final long serialVersionUID = 2146486523988671706L;
	
	private String name;
	private int age;
	private String addr;
	
	// 기본 생성자
	public Member() { }
	
	// 생성자
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}


