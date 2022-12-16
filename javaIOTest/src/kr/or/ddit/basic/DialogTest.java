package kr.or.ddit.basic;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {

	public static void main(String[] args) {
		// 자바의 GUI환경 발전 순서 : AWT --> SWING --> JavaFX
		
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
//		int result = chooser.showOpenDialog(new JPanel()); // 열기용
		int result = chooser.showSaveDialog(new JPanel()); // 저장용

		// Dialog창에 있는 '저장' 또는 '열기' 버튼을 눌렀을 경우..
		if(result == JFileChooser.APPROVE_OPTION) {
			
			// 선택한 파일 정보 가져오기
			File selectedFile = chooser.getSelectedFile();
			
			System.out.println("선택한 파일 : " 
					+ selectedFile.getAbsolutePath());
		}
		
		
		
		
		
		
		

	}

}












