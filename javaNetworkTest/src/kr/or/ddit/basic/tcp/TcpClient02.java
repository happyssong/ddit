package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient02 {

	public static void main(String[] args) {
		try {
			// 소켓 객체를 생성해서 서버에 접속 요청을 하고 서버와 접속이 완료되면
			// 메시지를 받는 쓰레드와 메시지를 보내는 쓰레드에
			// 이 소켓을 넘겨준다.
			Socket socket = new Socket("localhost", 7777);
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
