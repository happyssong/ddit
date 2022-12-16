package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileCopyDialog {

	public static void main(String[] args) {
		new FileCopyDialog().copyStart();
	}
	
	// 시작 메서드
	public void copyStart() {
		File file = showDialog("OPEN");
		
		if(file==null || !file.exists()) {
			System.out.println("선택한 파일이 없습니다.");
			System.out.println("복사 작업을 중단합니다.");
			return;
		}
		
		File targetFile = showDialog("SAVE");
		if(targetFile==null) {
			System.out.println("대상 파일 선택에 실패했습니다.");
			System.out.println("복사 작업을 중단합니다.");
			return;
		}
		
		
		try {
			// 원본 파일을 읽어올 스트림 객체 생성
			FileInputStream fin = new FileInputStream(file);
			BufferedInputStream bin = 
					new BufferedInputStream(fin);
			
			// 대상 파일에 출력할 스트림 객체 생성
			FileOutputStream fout = 
					new FileOutputStream(targetFile);
			BufferedOutputStream bout =
					new BufferedOutputStream(fout);
			
			
			System.out.println("복사 시작...");
			
// ----------------------------------------------------			
//			int data;  // 읽어온 데이터를 저장할 변수
//			
//			while((data=fin.read())!=-1) {
//				fout.write(data);
//			}
// ----------------------------------------------------

// ----------------------------------------------------
//			byte[] temp = new byte[1024];
//			int len = 0;
//			while((len=fin.read(temp))>0) {
//				fout.write(temp, 0, len);
//			}
//			fout.flush();
// ----------------------------------------------------
			
			byte[] temp = new byte[1024];
			int len = 0;
			while((len=bin.read(temp))>0) {
				bout.write(temp, 0, len);
			}
			bout.flush();
			
			
			// 스트림 닫기
//			fout.close();
//			fin.close();
			bout.close();
			bin.close();
			
			System.out.println("복사 작업 완료...");
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
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
