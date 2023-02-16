package ex06_select;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainClass {

	// select 결과 행이 1개인 경우
	public static void ex01() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 오직 SELECT문에서만 사용한다.
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
		
					Properties p = new Properties();
					p.load(new BufferedReader(new FileReader("db.properties")));
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				con= DriverManager.getConnection(url, p);
				
			String sql = "SELECT MEMBER_NO,ID,NAME,ADDRESS,JOIN_DATE";
			sql += " FROM MEMBER_TBL";
			sql += " WHERE MEMBER_NO = ?";
			
			ps = con.prepareStatement(sql);
			int memberNo = 2;
			ps.setInt(1,memberNo);
			
			rs = ps.executeQuery(); // SELECT문을 실행하는 메소드
			
			//System.out.println(rs.next()); // 첫 번째 결과 행이 있으면 true, 없으면 false
			//System.out.println(rs.next()); // 두 번째 결과 행이 있으면 true, 없으면 false
			
			//Member 객체 선언
			Member member = null;
			
			
			
			// 결과 행이 최대 1개 있으므로 if문으로 분기 처리
			if(rs.next()) {   // 결과 행이 1개 일때만 사용 // rs.next()호출은 if문에서 최초 1회 호출만 한다 다른데서 하지말기~~
				
				member = new Member();
				member.setMember_no(rs.getInt("MEMBER_NO"));
				member.setId(rs.getString("ID"));
				member.setName(rs.getString("NAME"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setJoin_date(rs.getDate("JOIN_DATE"));
				
				
				
				// 결과 행의 각 칼럼 정보 읽기(정보를 각각 따로따로 읽어들여온다 읽는 방법은 2가지가 있다(밑에 4번 주석보기`~)
				
				
				// 결과 행의 각 칼럼 정보를 읽어서 Memberm 객체 만들기
				
				
			}
			
			//if문이 종료된 뒤, member가 null 이라면 조회된 결과가 없었다는 의미가 된다. //그래서 선언과 생성코드를 꼭 분리해서 적어야 한다
			// 없을때를 대비해서...??
			System.out.println(member);
			
			
			/*
			 	| MEMBER_NO  | ID    | NAME   | ADDRESS | JOIN_DATE    |  최초 rs가 가르키는 위치 :  없음
			 	|    1       | admin |  관리자 | 서울    |   23/02/15 |   ←첫번째 rs.next() 호출한 경우 //한번에 한줄 씩만 조회할 수 있다.
			 	|    2       | master | 운영자 | 경기    |   23/02/16|    ←두번째 rs.next() 호출한 경우 //한번에 한줄 씩만 조회할 수 있다.
			 	  						 								  ←세번째 rs.next() 호출한 경우 결과가 없으므로  false가 반환된다.
			 	  														  
			 	
			 	1. ResultSet rs 객체는 하나의 행(Row)을 가르키는 포인터 역할이다. //행 데이터를 찾아갈 수 있게 가르키는 포인터 역할을 수행한다.
			 	2. next 메소드를 통해서 각 행(Row)을 가르킬 수 있다.
			 		1) next 메소드를 1번 호출하면 SELECT 전체 결과 중 1행을 가르킨다.
			 		2) next 메소드를 2번 호출하면 SELECT 전체 결과 중 2행을 가르킨다.
		 		3. next 메소드의 호출 결과는 boolean이다.
		 			1) 조회된 결과 행이 있으면 true가 반환된다.
		 			2) 조회된 결과 행이 없으면 false가 반환된다.
		 			
		 			rs의 next메소드를 가지고 호출해야 무언가 확인할 수 있다.
		 			
		 			
	 			4.결과 행의 칼럼 정보 가져오는 방법
	 				1) 칼럼의 이름을 그대로 사용한다.
	 					rs.getInt("MEMBER_NO")
	 					rs.getString("ID")
	 					rs.getString("NAME")
	 					rs.getString("ADDRESS")
	 					rs.getDate("JOIN_DATE")
 					2) 결과 행의 칼럼 순서대로 번호를 붙여서 사용한다.
 						rs.getInt(1)
	 					rs.getString(2)
	 					rs.getString(3)
	 					rs.getString(4)
	 					rs.getDate(5)
			 */
			
			


			
		}catch(Exception e) {
			e.printStackTrace();
			
			
			
		}finally {
			
			try {
				if(rs != null)rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	// select 결과 행이 2개 이상인 경우
	
	public static void ex02() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		String sql = null;
		
		
	try {
			
			Class.forName("oracle.jdbc.OracleDriver");
		
					Properties p = new Properties();
					p.load(new BufferedReader(new FileReader("db.properties")));
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				con= DriverManager.getConnection(url, p);
				
			sql = "SELECT MEMBER_NO,ID,NAME,ADDRESS,JOIN_DATE";
			sql += " FROM MEMBER_TBL";	//전체결과를 조회하겠다 =  select 행이 여러개가 나온다
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			// 결과 행이 여러개 있으므로 ArrayList를 준비한다.
			List<Member> memberList = new ArrayList<Member>();
			
			// 결과 행이 여러 개 있으므로 while문으로 반복 처리
			
			while(rs.next()) {
				
				Member member = new Member();
				member.setMember_no(rs.getInt("MEMBER_NO"));
				member.setId(rs.getString("ID"));
				member.setName(rs.getString("NAME"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setJoin_date(rs.getDate("JOIN_DATE"));
				
				
				// member 객체를 ArrayList에 저장하기
				memberList.add(member);
				
				
			
				

			
			}
			
			
			//While문이 종료된 뒤, ArratList의 크기가 0이라면 조회된 결과가 없었다는 의미가 된다.
			
			for(int i = 0; i < memberList.size(); i++) {
				System.out.println(memberList.get(i));
				
				
				
			}

			
		}catch(Exception e) {
			e.printStackTrace();
			
			
			
		}finally {
			
			try {
				if(rs != null)rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
		
	
	public static void main(String[] args) {
		ex02();
	}

}
