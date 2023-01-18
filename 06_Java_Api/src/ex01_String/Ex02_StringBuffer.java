package ex01_String;

public class Ex02_StringBuffer {

	public static void main(String[] args) {

		/* java.lang.StringBuffer 클래스(JDK 1.0)
			1. String을 연결하는 클래스이다.+연산자는 메모리를 많이 잡아먹어서 Buffer을 이용
			2. synchronized가 적용되어 멀티스레드 환경에서 사용이 가능하다.
			3. 동작이 느리다
			
		*/
		//StringBuffer 객체 생성
		StringBuffer stringBuffer = new StringBuffer();
		
		//문자열 추가(String의 + 연산자를 대신)
		stringBuffer.append("ba");
		stringBuffer.append("na");
		stringBuffer.append("na");
		
		//StringBuffer에 저장된 문자열을 String으로 변환
		String str = stringBuffer.toString();
		System.out.println(str);
		
	}

}
