package kr.or.ddit.vo;
/*
	DB테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스
	
	DB테이블의 '컬럼명'이 클래스의 '멤버변수'가 된다.
	DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.
*/
public class MemberVO {
	private String mem_id;
	private String mem_pass;
	private String mem_name;
	private String mem_tel;
	private String mem_addr;
	private String mem_photo;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_photo() {
		return mem_photo;
	}
	public void setMem_photo(String mem_photo) {
		this.mem_photo = mem_photo;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_name=" + mem_name + ", mem_tel="
				+ mem_tel + ", mem_addr=" + mem_addr + ", mem_photo=" + mem_photo + "]";
	}
	
}
