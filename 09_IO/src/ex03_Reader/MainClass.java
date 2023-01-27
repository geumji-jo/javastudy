package ex03_Reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	/*
		Reader
		1. 문자 기반의 입력 스트림이다.
		2. Reader로 끝나는 이름의 클래스는 모두 문자 기반의 입력 스트림이다.
		3. 문자를 읽어 들이는 스트림이다.(파일의 내용을 읽는다. 서버가 보낸 내용을 읽는다. 등등)
	 */

	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage") ;
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex01.txt");
		
		FileReader fr = null;
		
		try{
			fr = new FileReader(file);	// 입력 스트림의 이름 fr /Filereader의 reader가 통로
			
			int c;	// 1글자를 저장할 변수
			
			StringBuilder sb = new StringBuilder();
			while((c = fr.read()) != -1) {
				sb.append((char)c);	
			}
			
			System.out.println(sb.toString());
		
			
		}catch(IOException e ) {	//FilenotFoundException이 함께 처리된다.
			e.printStackTrace();
		}finally {
			
			try {
				if(fr != null) {
					fr.close();
				}
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex02() {
		
		File dir = new File("C:" +File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex02.txt");
		
		FileReader fr = null;
		
		try { 
			fr = new FileReader(file);
			
			char[] cbuf = new char[5];	 // 5글자를 읽어 들이는 배열
			
			while(true) {
				
				// ex02.txt 읽는 과정
				//루프	readCount   cbuf
				//1.	5			a b c d e
				//2.	2			f g c d e 
				//3.    -1
				int readCount = fr.read(cbuf);	// readCount : 읽은 글자의 개수
				
				if(readCount == -1) {
					break;
				}
				for(int i = 0 ; i < readCount; i++) {
					System.out.print(cbuf[i]);
				
					}
				}
			}catch(IOException e) {
				e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		ex02();
		
	}

}
