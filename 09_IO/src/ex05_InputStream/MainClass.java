package ex05_InputStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

import ex04_OutputStream.Person;

public class MainClass {
	
	
	public static void ex01() {
		
		File file =new File("c:" +File.separator+"storage" , "ex01.bin");	//읽어들일 파일경로
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream(file);
			
			
			// 입력단위
			// 1. int : 1개
			// 2: byte[] : 2개 이상
			
			int c = 0;
			StringBuilder sb = new StringBuilder();
			while((c=fis.read()) != -1) {
				sb.append((char)c);
			//	c = fis.read(); //하나만 읽어오기(int는 하나만 읽는 단위)
			//	if(c==-1) {
			//		break;
				}
				System.out.println(sb.toString());
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
			if (fis != null) {
				fis.close();
			
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void ex02() {
		
		
		// 원래 깨져서 출력됨(바이트 스트림과 한글 처리의 문제 확인)
		
		
	File file =new File("c:" +File.separator+"storage" , "ex02.bin");	//읽어들일 파일경로
		
		FileInputStream fis = null;	//읽어들이는 스트림
		
		try {
			
			fis = new FileInputStream(file);
			
			byte[] b = new byte[4];	// 한 번에 4바이트를 읽어 오시오.
			int readByte = 0;	//실제로 읽은 바이트를 저장해 두시오.
			StringBuilder sb = new StringBuilder();
			
			while((readByte = fis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte)); //배열 b의 인덱스 0부터 readByte 개 데이터를 사용한다.
			
			}
			
			//readByte = fis.read(b); 		//4바이트 저장했으니 4개씩 읽어오라.실제로 읽은걸  readbyte에 저장해라
			//if(readByte == -1) {
			//break;
			
			System.out.println(sb.toString());	
			
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null) {
					fis.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
				
			}
		}
		
	public static void ex02_complete() {
		
		// 바이트 입력 스트림을 문자 입력 스트림으로 변환하는 InputStreamReader
		
	File file =new File("c:" + File.separator + "storage" , "ex02.bin");	//읽어들일 파일경로
		

		InputStreamReader isr = null;
		
		
		
		try {
			
			isr = new InputStreamReader(new FileInputStream(file));	//읽어들이는 단위가 더이상 byte가 아님
			
			char[] cbuf = new char[4];	// 한 번에 4바이트를 읽어 오시오.
			int readCount = 0;
			StringBuilder sb = new StringBuilder();
			
			while((readCount = isr.read(cbuf)) != -1) {
				sb.append(cbuf, 0 , readCount); //배열 cbuf의 인덱스 0부터 readCount 개 데이터를 사용한다.
			
			}
			
			//readByte = fis.read(b); 		//4바이트 저장했으니 4개씩 읽어오라.실제로 읽은걸  readbyte에 저장해라
			//if(readByte == -1) {
			//break;
			
			System.out.println(sb.toString());	
			
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(isr != null) {
					isr.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
				
			}
		}
		
	public static void ex03() {
		
	File file = new File("C:" + File.separator +"storage", "ex03.bin");
	
	BufferedInputStream bis = null;
	
	try {
		bis = new BufferedInputStream(new FileInputStream(file));
		
		byte[] b = new byte[4];
		int readByte = 0;
		StringBuilder sb = new StringBuilder();
		
		while(((readByte = bis.read(b)) != - 1)) {
			sb.append(new String(b, 0, readByte));
			
		}
		
		System.out.println(sb.toString());
	}catch(IOException e ) {
		e.printStackTrace();
		
	}finally {
		try {
		if (bis != null) {
			bis.close();
		}
			
		}catch(IOException e ) {
			e.printStackTrace();
		}
	}
}
	
	public static void ex03_complete() {
		
		//버퍼 기반으로 읽기
		
		File file = new File("C:" + File.separator +"storage", "ex03.bin");
		 BufferedReader br = null;
		
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			

	
			while((line = br.readLine()) != null) {
				sb.append(line +"\n");
				
				
			}
			
			System.out.println(sb.toString());
			
		}catch(IOException e ) {
			e.printStackTrace();
			
		}finally {
			try {
			if (br != null) {
				br.close();
			}
				
			}catch(IOException e ) {
				e.printStackTrace();
			}
		}
	}
		
	
	
	public static void ex04() {
		
		// String name,int age , double height , boolean isAlive 순으로 값이 저장된 ex04.dat파일
		
		File file = new File("C:" + File.separator +"storage", "ex04.dat");
		 BufferedReader br = null;
		
		 DataInputStream dis = null;
		 
		 try {
			 
			 dis = new DataInputStream(new FileInputStream(file));
			 
			 
			 //String 
			 String name = dis.readUTF();
			int age = dis.readInt();
			 double height = dis.readDouble();
			 boolean isAlive = dis.readBoolean();
			 
			 System.out.println(name);
			 System.out.println(age);
			 System.out.println(height);
			 System.out.println(isAlive);
			 
			 
		 }catch(IOException e) {
			 e.printStackTrace();
		 }finally {
			 try {
				 if(dis != null) {
					 dis.close();
				 }
			 }catch(IOException e ) {
				 e.printStackTrace();
			 }
		 }
		 
		
	}
	
	
	public static void ex05() {
		
		//person 객체가 3개 저장되어 있는 (List<Person> 2개, Person 1개) ex05.dat파일
		
		File file = new File("C:" +File.separator +"storage", "ex05.dat" );
			ObjectInputStream ois= null;
		
		try {
			
			ois = new ObjectInputStream(new FileInputStream(file));
					
			// 입력
			// readObject 메소드는 Object를 반환하므로 적절하게 캐스팅 해야 한다.		
			@SuppressWarnings("unchecked")
			List<Person> people =(List<Person>)ois.readObject();		
			Person person = (Person)ois.readObject();
			
			
			System.out.println(people);
			System.out.println(person);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
		try {
			if(ois != null ) {
				ois.close();
		}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		ex05();
	}

}
