package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {

	public static void ex01() {      //ex01과 ex02가 같이 있어야 DB에 접속이 가능하다
		
		// 클래스를 로드하는 방법(메모리에 로드한다 :  사용하겠다)
		//어떤 클래스를 나 사용할게요~하고 메모리에 로드
		
		try {
			Class.forName("oracle.jdbc.OracleDriver") ;  //클래스이름으로 부르기 //oracle.jdbc.driverOracleDriver써도 문제없다~
			System.out.println("클래스가 로드되었습니다.");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
		
	}
	
	public static void ex02() {
		
		// Oracle DataBase와 연결할 때 사용하는 Connection 인터페이스
		
		
		Connection con = null;
		
		// Oracle 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "GDJ61";
		String password = "1111";
		
		// DriverManager 클래스로부터 Connection 객체를 받아 온다.
		try {
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB에 접속되었습니다.");
			
			
		}catch(SQLException e) {
			e.printStackTrace();	
		}
		try {
			if(con != null) {
			con.close();			// 사용이 끝난 Connection 객체는 반드시 닫아야 한다.
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
	ex02();
	

	}

}
