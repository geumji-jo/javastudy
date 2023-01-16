package ex08_interface;

/*
	용어 정리하기
	
	1. 클래스를 상속받는다.extends키워드를 사용한다.
		public class person {}
		public class Student extends Person{}
		
	2. 인터페이스를 구현한다.implements 키워드를 사용한다.
		pub;ic interface Person{}
		public class Student implements Person { }
 */


public class Student implements Person {

	@Override
	public void study() {
		System.out.println("공부한다");		
	}
	

}
