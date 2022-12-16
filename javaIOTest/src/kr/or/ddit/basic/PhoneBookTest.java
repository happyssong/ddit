package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
	문제) 이름, 전화번호, 주소를 멤버로 갖는 Phone클래스를 만들고
		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
	
	조건)
		- Map의 구조는 key값을 '이름'을 사용하고,
			value값으로 'Phone클래스의 인스턴스'로 한다.
		
		- 아래의 메뉴를 구성하고 해당 기능을 작성한다.
		--------------------
		1. 전화번호 등록
		2. 전화번호 수정
		3. 전화번호 삭제
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
		--------------------
		
		- 위 기능 중 삭제, 검색 기능은 '이름'을 입력 받아서 처리한다.
	
	- 추가 조건)
	 1) '6. 전화번호 저장' 메뉴를 추가하고 구현한다.
	 	(저장파일명은 'phoneData.dat'로 한다.)
	 2) 프로그램이 시작될 때 '저장된 파일'이 있으면 그 데이터를 읽어와
	 	Map에 셋팅한다.
	 3) 프로그램을 종료할 때 Map의 데이터가 수정되거나
	 	추가 또는 삭제되었으면 데이터를 저장한 후 종료되도록 한다.
		
	실행예시)
		--------------------
		1. 전화번호 등록
		2. 전화번호 수정
		3. 전화번호 삭제
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
		--------------------
		번호입력 >> 1
		
		새롭게 등록할 전환번호 정보를 입력하세요.
		이 름 >> 홍길동
		전화번호 >> 010-1111-1111
		주 소 >> 대전시 중구 오류동
		
		'홍길동' 전화번호 정보 등록 완료
		
		--------------------
		1. 전화번호 등록
		2. 전화번호 수정
		3. 전화번호 삭제
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
		--------------------
		번호입력 >> 1
		새롭게 등록할 전환번호 정보를 입력하세요.
		이 름 >> 홍길동
		
		'홍길동'은 이미 등록된 사람입니다.
		
		--------------------
		1. 전화번호 등록
		2. 전화번호 수정
		3. 전화번호 삭제
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
		--------------------
		번호입력 >> 5
		
		==========================================
		 번호     이   름     전화번호      주     소
		==========================================
		  1      홍길동    010-1111-1111 대전시 중고 오류동
		  ~~~
		  ~~~
		==========================================
		출력 완료...
		
		
		--------------------
		1. 전화번호 등록
		2. 전화번호 수정
		3. 전화번호 삭제
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
		--------------------
		번호입력 >> 0
		
		프로그램을 종료합니다.
		
*/
public class PhoneBookTest {
	// - Map의 구조는 key값을 '이름'을 사용하고,
	//		value값으로 'Phone클래스의 인스턴스'로 한다.
	private HashMap<String, Phone> phoneBookMap;
	private Scanner scan;
	private String fileName = "d:/d_other/phoneData.dat";
	
	// 데이터가 변경되었는지 여부를 나타내는 변수 선언
	// 데이터가 변경되면 이 변수값은 true가 된다.
	private boolean dataChange;
	
	// 생성자
	public PhoneBookTest() {
		scan = new Scanner(System.in);
		
//		phoneBookMap = new HashMap<String, Phone>();
		
		// 파일 내용을 읽어와 Map에 셋팅한다.
		phoneBookMap = load();
		
		// 파일이 없거나 오류가 있을 때...
		if(phoneBookMap==null) {
			phoneBookMap = new HashMap<String, Phone>();
		}
	}
	
	
	public static void main(String[] args) {
		new PhoneBookTest().phoneBookStart();
	}
	
	// 시작 메서드
	public void phoneBookStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice){
				case 1 :	// 등록
					insert(); break;
				case 2 :	// 수정
					update(); break;
				case 3 :	// 삭제
					delete(); break;
				case 4 :	// 검색
					search(); break;
				case 5 :	// 전체 출력
					displayAll(); break;
				case 6 :	// 저장
					save(); break;
				case 0 :	// 프로그램 종료
					if(dataChange==true) { // 데이터가 변경되었으면...
						save();
					}
					System.out.println("프로그램을 종료합니다.");
					return;
				default :
					System.out.println("작업 번호를 잘못 입력했습니다.");
					System.out.println("다시 입력하세요.");
			}
		}
	}
	
	// 전화번호 정보가 저장된 파일을 읽어오는 메서드
	// 반환값 : 읽어온 Map객체 (읽어올 파일이 없으면 null반환)
	private HashMap<String, Phone> load(){
		// 읽어온 데이터가 저장될 변수 선언
		HashMap<String, Phone> pMap = null;
		
		File file = new File(fileName);
		if(!file.exists()) {  // 저장된 파일이 없으면...
			return null;
		}
		
		// 저장될 파일이 있을 경우의 처리 내용...
		ObjectInputStream oin = null;
		try {
			// 입력용 스트림 객체 생성
			oin = new ObjectInputStream(
				new BufferedInputStream(
					new FileInputStream(file)
				)
			);
			
			// 파일 내용을 읽고, 읽어온 객체를 변수에 저장한다.
			pMap = (HashMap<String, Phone>) oin.readObject();
			
		} catch (IOException e) {
			//e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			return null;
		} finally {
			if(oin!=null) {
				try { oin.close(); } catch(IOException e) {}
			}
		}
		
		return pMap;
	}
	
	
	
	// 전화번호 정보를 저장하는 메서드
	private void save() {
		ObjectOutputStream oout = null;
		try {
			// 출력용 객체 스트림 생성
			oout = new ObjectOutputStream(
				new BufferedOutputStream(
					new FileOutputStream(fileName)
				)
			);
			
			// Map객체를 파일로 저장한다.
			oout.writeObject(phoneBookMap);
			
			dataChange = false;
			
			System.out.println("저장이 완료되었습니다.");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 스트림 객체 닫기
			if(oout!=null) {
				try { oout.close();	} catch (IOException e) { }
			}
		}
		
		
	}
	
	
	
	// 전화번호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		// 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		
		Phone p = phoneBookMap.get(name);
		
		System.out.println(name + "씨의 전화번호 정보");
		System.out.println("======================");
		System.out.println("이   름 : " + p.getName());
		System.out.println("전화번호 : " + p.getTel());
		System.out.println("주   소 : " + p.getAddr());
		System.out.println("======================");
		System.out.println();
		
	}
	
	// 전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		// 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		
		phoneBookMap.remove(name);
		
		dataChange = true;
		
		System.out.println(name + "씨의 정보를 삭제했습니다.");
	}
	
	
	// 전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		// 해당 정보가 없으면 수정 작업 진행 불가...
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		
		System.out.print("새로운 전화번호 >> ");
		String newTel = scan.next();
		
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("새로운 주소 >> ");
//		String newAddr = scan.next();
		String newAddr = scan.nextLine();
		
		// Map의 수정작업 ==> 같은 key값에 새로운 value값을 저장하기
		phoneBookMap.put(name, new Phone(name, newTel, newAddr));
		
		dataChange = true;
		
		System.out.println(name + "씨의 전화번호 정보를 변경했습니다.");
		
	}
	
	
	// 전체 자료를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		
		Set<String> phoneKeySet = phoneBookMap.keySet();
		System.out.println("==========================================");
		System.out.println("번호     이   름     전화번호      주     소");
		System.out.println("==========================================");
		if(phoneKeySet.size()==0) {
			System.out.println("등록된 전화번호 정보가 하나도 없습니다.");
		}else {
			int cnt = 0;
			for(String key : phoneKeySet) {
				cnt++;
				// key값(이름)을 이용하여 value값(Phone객체) 구하기
				Phone p = phoneBookMap.get(key);
				
				System.out.println(cnt + "\t" + p.getName() 
					+ "\t" + p.getTel() + "\t" + p.getAddr() );
			}
		}
		System.out.println("==========================================");
		System.out.println("출력 끝...");	 
		
	}
	
	
	// 새로운 전화번호 정보를 등록하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전환번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		// 이미 등록된 사람인지 여부 검사
		if(phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}
		
		System.out.print("전화번호 >> ");
		String tel = scan.next();
		
		// 입력버퍼 비우기는 nextLine()메서드를 사용하기 전에
		// nextLine()이외의 입력 메서드를 사용했을 경우에만 사용한다.
		scan.nextLine();  // 입력 버퍼 비우기
		
		System.out.print("주소 >> ");
		//String addr = scan.next();
		String addr = scan.nextLine();
		
		/*
		// 방법1
		Phone p = new Phone(name, tel, addr);
		phoneBookMap.put(name, p);
		*/
		
		// 방법2
		phoneBookMap.put(name, new Phone(name, tel, addr));
		
		dataChange = true;
		
		System.out.println(name + " 전화번호 정보 등록 완료!!");
		
	}
/*	
	next(), nextInt(), nextDouble(),....
	==> 사이띄기, Tab키, Enter키를 구분문자로 분리해서 분리된 자료만 읽어간다. 
	
	nextLine()
	==> 한 줄 단위로 입력한다. 즉, 자료를 입력하고 Enter키를 누르면
		Enter키까지 읽어가서 Enter키 앞까지를 반환한다.
		
	--> Scanner로 입력하면 입력한 값은 입력 버퍼에 저장된 후에
		차례로 꺼내와서 처리한다.
		
	가가가
	나나나
	
	다다다 라라라
	
		
		
*/	
	// 메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("--------------------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("6. 전화번호 저장");
		System.out.println("0. 프로그램 종료");
		System.out.println("--------------------");
		System.out.print("번호입력 >> ");
		return scan.nextInt();
	}

}


// 전화번호 정보를 저장할 class 작성
// 이름, 전화번호, 주소를 멤버로 갖는 Phone클래스 만들기
class Phone implements Serializable{
	private static final long serialVersionUID = 2921641838928418694L;
	
	private String name;
	private String tel;
	private String addr;
	
	// 기본 생성자
	public Phone() { }
	
	// 생성자
	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
}















