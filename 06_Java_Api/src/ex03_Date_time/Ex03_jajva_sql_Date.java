package ex03_Date_time;

import java.sql.Date;

public class Ex03_jajva_sql_Date {

	public static void main(String[] args) {
		
		//Oracle 데이터베이스와 호환되는 java.sql.Date
				
		Date now = new Date(System.currentTimeMillis());
		System.out.println(now);

	}

}
