package ex02_Random;

import java.util.UUID;

public class Ex04_UUID {

	public static void main(String[] args) {
		
		/*
		java.util.UUID 
		다른이름이 만들어지는걸 보증//한글같은 파일 인코딩 필요없게끔 숫자로 관리하는 역할
		1. 전역 고유 식벌자(Universal Unique IDentifoer)
		2. 32개의 16진수와 4개의 하이픈(-)로 구성된 식별자 값이다.	
		*/
		
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		
		// 하이픈(-) 모두 없애기 : 모든 하이픈(-)을 빈 문자열("")로 바꾸기
		String replaceStr = str.replace("-", "");
			System.out.println(replaceStr);
	}
		
	}


