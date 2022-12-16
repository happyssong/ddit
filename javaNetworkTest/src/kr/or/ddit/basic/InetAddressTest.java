package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 ==> IP주소를 다루기 위한 클래스
		
		// 객체 생성 
		// 형식) InetAddress.getByName("도메인명 또는 IP주소")
		
		// www.naver.com의 IP정보 가져오기
		InetAddress naverIp = 
			InetAddress.getByName("www.naver.com");
		
		System.out.println("HostName : " + naverIp.getHostName());
		System.out.println("HostAddress : " + naverIp.getHostAddress());
		System.out.println("toString : " + naverIp.toString());
		System.out.println();
		
		// 자신의 컴퓨터의 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내컴의 HostName : " + localIp.getHostName());
		System.out.println("내컴의 HostAddress : " + localIp.getHostAddress());
		System.out.println("내컴의 toString : " + localIp.toString());
		System.out.println();
		
		// IP주소가 여러개인 호스트의 IP정보 가져오기
		InetAddress[] naverArr = 
				InetAddress.getAllByName("www.naver.com");
		for(InetAddress ip : naverArr) {
			System.out.println(ip.toString());
		}
		
		
	}

}











