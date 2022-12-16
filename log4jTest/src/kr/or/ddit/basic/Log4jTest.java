package kr.or.ddit.basic;

import org.apache.log4j.Logger;

public class Log4jTest {
	// Logger클래스의 인스턴스를 받아온다.
	static Logger logger = Logger.getLogger(Log4jTest.class);
	
	
	public static void main(String[] args) {
		// log기록을 남기는 방법
		// 형식1) Logger객체변수.로그레벨명("출력할 메시지");
		// 형식2) Logger객체변수.log(Level.로그레벨명, "출력할 메시지");
		logger.trace("이것은 레벨이 Trace인 출력 내용입니다.");
		logger.debug("이것은 레벨이 Debug인 출력 내용입니다.");
		logger.info("이것은 레벨이 INFO인 출력 내용입니다.");
		logger.warn("이것은 레벨이 Warn인 출력 내용입니다.");
		logger.error("이것은 레벨이 Error인 출력 내용입니다.");
		logger.fatal("이것은 레벨이 Fatal인 출력 내용입니다.");
		
	}

}
