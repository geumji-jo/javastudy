package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MemberTableMainClass {

	public static void main(String[] args) {
		
		
		/* 1. Connection 생성 */
		
		Connection con = null;
		
		
		try {
			// 오라클 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 프로퍼티 파일 읽어서 프로퍼티 객체 생성
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));  //프로퍼티 파일을 불러서 읽어내기
			
			//프로퍼티 객체에 저장된 각 프로퍼티(속성) 가져오기
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			// Connection 생성
			con = DriverManager.getConnection(url, user, password);
			
			
			
			
			System.out.println("접속되었습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		/* 2. 쿼리문 작성 및 실행 */
		
		/*
		 	PreparedStatement 인터페이스 (준비된 구문)
		 	
		 	1.Prepared : 미리 준비하시오.
		 	2.Statement : 쿼리문을 
		 	3.작성된 커리문을 전달하면 해당 쿼리문을 실행해 주는 역할을 수행한다.
		 	4.Statement 인터페이스는 보안 문제로 사용하지 않는 것이 좋다. (PreparedStatement 인터페이스 말고 Statement 인터페이스라는게 따로 있다)
		 	
		 	
		 	
		 	Statement인터페이스를 쓰면 SQL 인젝션 문제가 생길수 있다.
		 	그래서 PreparedStatement 인터페이스를 사용해야 한다.
		 	
		 	
		 	SELECT * FROM ID = 변수 AND PW = 변수;
		 	아이디에 입력한 값 : aaa OR 1 = 1 --
		 	비밀번호에 입력한 값 : aaa
		 	SELECT * FOR ID =aaa OR 1 =1 --  AND PW = aaa;
		 	
		 */
		// Jdbc에서는 쿼리문의 마지막에 세미콜론(;)을 붙이지 않는다.
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE MEMBER_TBL (");
		sb.append("MEMBER_NO NUMBER NOT NULL");
		sb.append(", ID VARCHAR2(30 BYTE) NOT NULL UNIQUE");
		sb.append(", NAME VARCHAR2(30 BYTE) NOT NULL");
		sb.append(", ADDRESS VARCHAR2(30 BYTE)");
		sb.append(", JOIN_DATE DATE NOT NULL");
		sb.append(", CONSTRAINT PK_MEMBER PRIMARY KEY (MEMBER_NO))");
		
		
		String sql = sb.toString();
	
		
		
		PreparedStatement ps = null;
	
		
		  try {

		         // PreparedStatement 객체 생성
		         ps = con.prepareStatement(sql);

		         // 쿼리문 실행하기
		         ps.execute();
		         System.out.println("쿼리문이 실행되었습니다."); // 실행여부 test

		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		      /* 3. 사용한 자원 반납하기 Connection, Prepared */

		      try {

		         if (ps != null)ps.close();
		         if (con != null)con.close();

		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		   }

		}