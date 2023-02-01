package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class XMLMainClass {

	public static void ex01() {
		
		/*
		 한국공항공사_항공기 운항정보 :  공항 코드 정보
		 1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
		 2. 요청변수 ( Request Parameter)
		 	1)serviceKey :인증키를 의미
		 	
		 */
		
		String serviceKey = "SJx3sxXn3G3c0OZqCFmximZKaegFUpfy26K/6UCc2D79LdMHvC1wjUSfUDqSgP1C1PH0/X8oG0JTiNvvN6vFUw==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
		apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8");			//주소창에 필요한 주소를 ?붙여서 파라미터 가져오는방식 get방식
		url = new URL(apiURL);
		con= (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");    					//GET은 무조건 대문자
		con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8" );		//xml문서의 데이터타입 application/xml
		
		int responseCode = con.getResponseCode();
		if(responseCode == 200) {		//HttpURLConnection.HTTP_OK이 200을 의미한다.
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
		}else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line= reader.readLine()) != null) {
			sb.append(line);
			
			
		}
		
		reader.close();
		con.disconnect();
		
		File file = new File("C:"+ File.separator+ "storage", "공항코드정보.xml");
		writer = new BufferedWriter(new FileWriter(file));
		writer.write(sb.toString());
		writer.close();
		
		System.out.println("공항코드정보.xml이 생성되었습니다.");
		
		
		}catch(Exception e ) {
			e.printStackTrace();
		}
	
				
		
		
	}
		
	
	public static void ex02() {

		
		/*
		 한국공항공사_항공기 운항정보 :  공항 코드 정보
		 1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
		 2. 요청변수 ( Request Parameter)
		 	1) serviceKey      :인증키를 의미
		 	2) pageNo          : 조회할 페이지번호
		 	3) schDate         : 검색일자
		 	4) chDeptCityCode  :출발도시코드
		 	5) secArrvCityCode : 도착도시코드
		 */
		
		String serviceKey = "SJx3sxXn3G3c0OZqCFmximZKaegFUpfy26K/6UCc2D79LdMHvC1wjUSfUDqSgP1C1PH0/X8oG0JTiNvvN6vFUw==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8");			//주소창에 필요한 주소를 ?붙여서 파라미터 가져오는방식 get방식
			apiURL += "&pageNo=1";
			apiURL += "&schDate=20230201";
			apiURL += "&schDeptCityCode=ICN";
			apiURL += "&secArrvCityCode=JFK";
			
			url = new URL(apiURL);
			con= (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");    					//GET은 무조건 대문자
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8" );		//xml문서의 데이터타입 application/xml
			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {		//HttpURLConnection.HTTP_OK이 200을 의미한다.
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line= reader.readLine()) != null) {
				sb.append(line);
				
				
			}
			
			reader.close();
			con.disconnect();
			
			File file = new File("C:"+ File.separator+ "storage", "국제선운항스케쥴.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("국제선운항스케쥴.xml이 생성되었습니다.");
			
			
			}catch(Exception e ) {
				e.printStackTrace();
			}
		
					
		
	}
		
	public static void main(String[] args) {
		ex02();
			
			
			
		}
		
		
		

	}


