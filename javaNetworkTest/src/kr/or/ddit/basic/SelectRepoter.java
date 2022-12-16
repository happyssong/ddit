package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Collections;

public class SelectRepoter {

	public static void main(String[] args) {
		String[][] members = {
			{"구지현","김호겸","장윤식","장혜연"},
			{"윤정식","이원걸","이주원","조수빈"},
			{"강명범","김건호","이유영","이찬솔"},
			{"김유리","오용택","정경환","최지훈","홍무곤"},
			{"강은비","유헌호","임지수","최현우"},
			{"방형준","이유화","임찬우","정요한"},
		};
		/*
		String[] reporters = new String[members.length];
		
		for(int i=0; i<members.length; i++) {
			int index = (int)(Math.random() * members[i].length);
			reporters[i] = members[i][index];
		}
		
		System.out.println("=== 발표자 ===");
		for(int i=0; i<reporters.length; i++) {
			System.out.println((i+1) + "조 발표자 : " + reporters[i]);
		}
		System.out.println();
		
		Collections.shuffle(Arrays.asList(reporters));
		
		System.out.println("발표순서");
		System.out.println(Arrays.toString(reporters));
		*/
		int index1 = (int)(Math.random() * members.length);
		int index2 = (int)(Math.random() * members[index1].length);
		
		System.out.println(members[index1][index2]);
		
	}

}
