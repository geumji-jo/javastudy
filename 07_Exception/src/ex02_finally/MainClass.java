package ex02_finally;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		// finally 블록
		// 항상 마지막에 실행되는 블록으로 필요 없으면 생략할 수 있다.
	
		
		
		Scanner sc = null;	//선언과 생성을 분리 //변수를 선언할때 초기값을 주는 연습하기
	try {
		sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요. >>> ");
		int age = sc.nextInt();
		System.out.println(age >= 20 ? "주류 구매 가능" : "주류 구매 불가능");
		}catch(Exception e) {
			System.out.println("예외 발생");
			
		}  finally {
			sc.close();	//finally블록은 자원(resource)을 반납할 때 주로 사용한다.
			
		}
	}

}
