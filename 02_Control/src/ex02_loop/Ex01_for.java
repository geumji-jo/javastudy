package ex02_loop;

public class Ex01_for {
	
	/*
	 	for문
	 	1. 연속된 숫자를 생성하는 반복문(배열에서 많이 사용)
	 	2. 형식
	 		for(초기문; 조건문; 증감문) {
	 			실행문
 			}
	 */
	
	public static void ex01() {
		
		//1 ~10
		for(int a = 1; a <= 10; a++) {
			System.out.println(a);
		}
		
	}
	
	public static void ex02() {
		
		// 횟수(5번)
		int count = 5;
		
		for(int a = 0; a < count; a++) {
			System.out.println("Hello World");			
		}
		
	}
	
	public static void ex03() {	//연습
		
		// 10 ~ 1
		for(int a = 10; a >= 1; a--) {
			System.out.println(a);
		}
		
	}
	
	public static void ex04() {	//연습
		
		// 구구단 2단 출력
		// 2 * 1 = 2
		// 2 * 2 = 4
		// ...
		int dan = 2;	// 이 곳에 원하는 구구단을 넣으면 된다.
		
		for(int a = 1; a <= 9; a++) {
			System.out.println(dan + " X " + a + " = " + dan * a);
		}	
	}
	public static void main(String[] args) {
		ex04();
		
	}

}
