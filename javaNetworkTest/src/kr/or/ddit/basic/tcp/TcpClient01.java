package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		- 현재 자신 컴퓨터를 나타내는 방법
		1) 원래의 IP주소 : 예) 192.168.143.3
		2) 지정된 IP주소 : 127.0.0.1
		3) 원래의 컴퓨터 이름 : 예) SEM, DESKTOP-963G6R1
		4) 지정된 컴퓨터 이름 : localhost
		*/
		
		String serverInfo = "localhost";
		System.out.println(serverInfo + " 서버에 연결 중입니다...");
		
		// 서버의 IP주소와 Port번호를 지정하여 Socket객체를 생성한다.
		// ==> Socket객체는 생성이 완료되면 해당 서버로 연결 요청을 보낸다.
		Socket socket = new Socket(serverInfo, 7777);
		
		// Socket객체가 정상적으로 생성되었다면 서버와 연결이 완료되었다는 의미이다.
		// 이 객체 생성 명령 이후에는 연결된 후의 작업을 기술하면 된다.
		
		// 서버가 보내온 메시지를 받아서 출력하기
		
		// Socket객체의 InputStream객체를 통해서 자료를 받는다.
		// ==> Socket객체의 getInputStream()메서드를 이용해서 생성한다.
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		// 서버가 보낸 메시지를 받아서 화면에 출력하기
		// ==> 데이터를 수신하는 것은 read계열의 메서드를 이용한다.
		System.out.println("서버에서 보낸 메시지 : " + din.readUTF());
		System.out.println();
		
		System.out.println("연결을 종료합니다...");
		
		// 소켓과 스트림 닫기
		din.close();
		socket.close();
		
		
	}

}







