package ex01_Thread;


/*
Thread 클래스를 상속하는 방법
1. extends Thread 처리한다.
2. Thread 클래스가 가진 public void run() 메소드를 오버라이드 한다.
3. Thread 객체를 만든다.
4. Thread 객체가 가진 run 메소드는 start() 메소드로 호출한다.
*/
public class Calculator extends Thread{

	private String name;
	public Calculator(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		
		long n= 2000000000L;
		System.out.println(name + "계산기가 계산합니다.");
		
		
		
		//1부터 n사이의 모든 정수를 곱하기
		long result = 0; //곱하기의 결과는 초기화를 1로 잡아주면 좋다
		for(int i =1; i <= n; i ++) {
			result += i;	// result *=1; result *=2; .....result*=n;
			
			
		}
		System.out.println(n+ "까지 더한 값은 " + result + "입니다.");
	}
	
}
