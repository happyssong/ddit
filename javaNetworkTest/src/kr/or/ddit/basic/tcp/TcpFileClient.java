package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
서버와 클라이언트가 접속이 완료되면
클라이언트가 'd:/d_other/펭귄.jpg'파일을 서버로 전송한다.
서버는 클라이언트가 보내온 파일을 받아서
'd:/d_other/연습용'폴더에 저장한다.

*/

public class TcpFileClient {
	private Socket socket;
	private BufferedInputStream bin;
	private BufferedOutputStream bout;
	private DataOutputStream dout;
	
	public static void main(String[] args) {
		new TcpFileClient().clientStart();
	}
	
	public void clientStart() {
		// 전송할 파일 정보를 갖는 File객체 생성
//		File file = new File("d:/d_other/펭귄.jpg");
		File file = showDialog("OPEN");
		if(file==null) {
			System.out.println("전송할 파일을 선택하지 않았습니다.");
			return;
		}
		String fileName = file.getName();
		if(!file.exists()) {
			System.out.println(fileName + " 파일이 없습니다.");
			System.out.println("작업 종료...");
			return;
		}
		
		try {
			socket = new Socket("localhost", 7777);
			
			System.out.println("파일 전송 시작...");
			
			dout = new DataOutputStream(socket.getOutputStream());
			
			// 서버와 접속이 완료되면 전송할 파일이름을 제일 먼저 전송한다.
			dout.writeUTF(fileName);
			
			// 파일 읽기용 스트림 객체 생성
			bin = new BufferedInputStream(
					new FileInputStream(file)
				);
			
			// 서버로 출력(전송)하기 위한 출력용 스트림 객체 생성
			bout = new BufferedOutputStream(
					socket.getOutputStream()
				);
			
			byte[] temp = new byte[1024];
			int len = 0;
			while((len=bin.read(temp))>0) {
				bout.write(temp, 0, len);
			}
			bout.flush();
			
			System.out.println("파일 전송 완료...");
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패!!!");
			e.printStackTrace();
		} finally {
			// 사용했던 스트림과 소켓 닫기
			if(dout!=null) try {dout.close(); }catch(IOException e) {}
			if(bin!=null) try {bin.close(); }catch(IOException e) {}
			if(bout!=null) try {bout.close(); }catch(IOException e) {}
			if(socket!=null) try {socket.close(); }catch(IOException e) {}
		}
	}
	
	
	// Dialog창을 띄워주고 선택한 파일 정보를 반환하는 메서드
	public File showDialog(String option) {
		// SWING의 파일 열기, 저장 창 연습
		JFileChooser chooser = new JFileChooser();
		
		//선택할 파일의 종류(확장자로 구분) 설정
		FileNameExtensionFilter doc =
			new FileNameExtensionFilter("MS Word File", 
					"docx", "doc");
		FileNameExtensionFilter img =
			new FileNameExtensionFilter("Images File", 
					new String[] {"png", "jpg", "gif"});
		FileNameExtensionFilter pdf =
				new FileNameExtensionFilter("PDF File", "pdf");
		FileNameExtensionFilter txt =
				new FileNameExtensionFilter("Text File", "txt");
		
		// FileChooser에 선택할 파일 종류 등록
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(pdf);
		chooser.addChoosableFileFilter(txt);
		
		// 확장자 목록 중에서 처음부터 선택될 확장자 지정하기
		chooser.setFileFilter(txt);  
		
		// 모든 파일 목록 표시 여부 설정하기 (true:설정, false:해제)
		chooser.setAcceptAllFileFilterUsed(true);
		
		// Dialog창에 나타날 기본 경로 설정하기
		chooser.setCurrentDirectory(new File("d:/d_other"));
		
		
		// 창 띄우기
		int result;
		if("SAVE".equals(option.toUpperCase())) {
			result = chooser.showSaveDialog(new JPanel()); // 저장용
		}else if("OPEN".equals(option.toUpperCase())) {
			result = chooser.showOpenDialog(new JPanel()); // 열기용
		}else {
			System.out.println("option은 'SAVE' 또는 'OPEN'만 가능합니다.");
			return null;
		}

		File selectedFile = null;

		// Dialog창에 있는 '저장' 또는 '열기' 버튼을 눌렀을 경우..
		if(result == JFileChooser.APPROVE_OPTION) {
			selectedFile = chooser.getSelectedFile();
		}
		
		return selectedFile;
	}
	

}













