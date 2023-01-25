package javavjungsuk;

class Data {int  x; }

public class Ex06_6 {

	public static void main(String[] args) {	//1. 메인 메서드 실행

		Data d = new Data();	 //참조변수 d를 만들고 Data 객체를 생성
		d.x = 10;	//참조변수 d가 가르키는  객체 x의 값을 10으로 초기화
		System.out.println("main() : x = " + d.x);
		
		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x);
	}
	
	static void change (int x ) {	//기본형 매개변수
		
		x = 1000;
		System.out.println("change() : x = " + x);
	}

}
