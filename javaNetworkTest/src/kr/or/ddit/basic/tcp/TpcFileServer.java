package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
서버와 클라이언트가 접속이 완료되면
클라이언트가 'd:/d_other/펭귄.jpg'파일을 서버로 전송한다.
서버는 클라이언트가 보내온 파일을 받아서
'd:/d_other/연습용'폴더에 저장한다.

*/
public class TpcFileServer {
	private ServerSocket server;
	private Socket socket;
	private BufferedInputStream bin;
	private BufferedOutputStream bout;
	private DataInputStream din;
	

	public static void main(String[] args) {
		new TpcFileServer().serverStart();
	}
	
	public void serverStart() {
		// 저장할 폴더 정보를 갖는 File객체 생성
		File saveDir = new File("d:/d_other/연습용");
		if(!saveDir.exists()) {
			// 저장할 폴더가 없으면 새로 만들어 준다.
			saveDir.mkdirs();
		}
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다...");
			
			socket = server.accept(); // 클라이언트 요청 기다리기
			
			System.out.println("파일 저장 시작...");
			
			// 클라이언트가 맨 처음 보낸 '파일명'데이터를 받을 
			// 입력용 스트림 객체 생성
			din = new DataInputStream(socket.getInputStream());
			
			String fileName = din.readUTF(); // 파일명 받기
			
			// 파일 저장위치와 파일명을 지정하여 File객체 생성
			File file = new File(saveDir, fileName);
			
			// 클라이언트가 전송할 파일 내용을 읽어서 저장할 스트림 객체 생성
			bin = new BufferedInputStream(
					socket.getInputStream());
			bout = new BufferedOutputStream(
					new FileOutputStream(file));
			
			byte[] temp = new byte[1024];
			int len = 0;
			while((len=bin.read(temp))>0) {
				bout.write(temp, 0, len);
			}
			
			bout.flush();
			System.out.println("파일 저장 완료...");
			
			
		} catch (Exception e) {
			System.out.println("파일 저장 실패!!!");
			e.printStackTrace();
		} finally {
			// 사용했던 자원 닫기.
			if(din!=null) try {din.close();}catch(IOException e) {}
			if(bin!=null) try {bin.close();}catch(IOException e) {}
			if(bout!=null) try {bout.close();}catch(IOException e) {}
			if(socket!=null) try {socket.close();}catch(IOException e) {}
			if(server!=null) try {server.close();}catch(IOException e) {}
		}
		
		
		
		
	}

}









