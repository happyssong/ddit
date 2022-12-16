package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	// 접속한 클라이언트 정보를 저장할 Map객체 선언
	//	==> key값 : 접속한 사람 대화명, value값 : 접속한 클라이언트의 Socket객체
	private Map<String, Socket> clientMap;
	
	// 생성자
	public TcpMultiChatServer() {
		// clientMap을 동기화 처리가 되도록 한다.
		clientMap = Collections.synchronizedMap(
				new HashMap<String, Socket>()
			);
	}
	
	public static void main(String[] args) {
		new TcpMultiChatServer().serverStart();
	}
	
	public void serverStart() {
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다...");
			
			while(true) {
				socket = server.accept();
				System.out.println("[" + socket.getInetAddress()
					+ " : " + socket.getPort() + "]에서 접속했습니다."
				);
				//---------------------------
				
				// 쓰레드 생성 후 실행하기
				ServerReceiver serverThread = 
						new ServerReceiver(socket);
				serverThread.start();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}  // serverStart() 메서드 끝...
	
	// clientMap에 저장된 전체 사용자에게 메시지를 전송하는 메서드
	private void sendToAll(String msg) {
		// clinetMap의 데이터 개수만큼 반복
		for(String key : clientMap.keySet()) {
			try {
				// key값에 대응하는 Socket객체의 출력용 스트림을
				// 이용한 출력용 스트림 객체 생성
				DataOutputStream dout = 
					new DataOutputStream(
						clientMap.get(key).getOutputStream());
				dout.writeUTF(msg);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	} //  sendToAll()메서드 끝...
	
	//-----------------------------------------------
	
	// Inner Class로 서버에서 클라이언트로 메시지를 전송하는 Thread 작성하기
	//	==> 이유 : Outer Class의 멤버변수를 사용하기 위해서..
	class ServerReceiver extends Thread{
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;
		
		// 생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				// 수신용 스트림 객체 생성
				din = new DataInputStream(socket.getInputStream());
				
				// 송신용 스트림 객체 생성
				dout = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} // 생성자 끝...
		
		@Override
		public void run() {
			String name = "";  // 접속한 클라이언트의 대화명이 저장될 변수
			try {
				// 클라이언트가 연결이 성공되면 처번째 데이터로 '대화명'을 입력받아 보낸다.
				// 서버에서는 이 '대화명'의 중복여부를 판단하여 응답으로 보낸다.
				
				// 클라이언트가 보낸 '대화명'이 중복되지 않을때까지 반복하는 반복문
				while(true) {
					name = din.readUTF();  // 클라이언트가 보내온 '대화명'받기
					
					// '대화명'의 중복 여부 확인
					if(clientMap.containsKey(name)) { // 중복되면...
						dout.writeUTF("대화명중복");  // '대화명중복'메시지를 응답으로 보내기
					}else { // 중복되지 않을 때...
						dout.writeUTF("OK"); // 'OK'메시지를 응답으로 보내기
						break;  // 반복문 탈출...
					}
				} // while문 끝...
				
				// 접속한 사람의 대화명을 이용하여 다른 모든 접속자들에게
				// 대화방 참여 메시지를 전송한다.
				sendToAll("[" + name + "]님이 대화방에 입장했습니다...");
				
				// 접속한 사람의 대화명과 Socket객체를 clientMap에 추가한다.
				clientMap.put(name, socket);
				
				System.out.println("현재 접속자 수 : " + 
						clientMap.size() + "명");
				
				// 한 클라이언트가 보낸 메시지를 받아서
				// 전체 클라이언트들에게 보낸다.
				while(din!=null) {
					sendToAll(din.readUTF());
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				// 이 finally영역이 실행된다는 것은 클라이언트가 접속을
				// 종료했다는 의미이다.
				sendToAll("[" + name + "]님이 접속을 종료했습니다...");
				
				// clientMap에서 해당 대화명을 삭제한다.
				clientMap.remove(name);
				
				System.out.println("[" + socket.getInetAddress()
					+ " : " + socket.getPort() + "]에서 접속을 종료했습니다."
				);
				System.out.println("현재 접속자 수 : " + 
						clientMap.size() + "명");
				System.out.println();
				
			}
			
			
		}
	}
	
	
	
	

}












