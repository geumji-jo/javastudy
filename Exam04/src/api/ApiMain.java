package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain {

	public static void main(String[] args) {
		
	
		
		try {
			String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
			apiURL += "?serviceKey=" + URLEncoder.encode("SJx3sxXn3G3c0OZqCFmximZKaegFUpfy26K/6UCc2D79LdMHvC1wjUSfUDqSgP1C1PH0/X8oG0JTiNvvN6vFUw==","UTF-8");		// 서비스키에  %들어가면 인코딩 된 서비스키다	
			apiURL += "&searchYear=" + URLEncoder.encode("2021","UTF-8");		
			apiURL += "&siDo=" + URLEncoder.encode("1100","UTF-8");		// 변화에 강한 코드형식
			apiURL += "&guGun=" + URLEncoder.encode("1125","UTF-8");		
			apiURL += "&type=" + URLEncoder.encode("json","UTF-8");		
			apiURL += "&numOfRows=" + URLEncoder.encode("10","UTF-8");		
			apiURL += "&pageNo=" + URLEncoder.encode("1","UTF-8");		
			
			
			// API주소
		
						
			// URL 객체 생성(API 주소의 형식 검증)
			URL url = new URL(apiURL);
			
			// API주소 접속
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
					
			// GET방식의 요청임을 처리
			con.setRequestMethod("GET");   //주소창에 파라미터를 주렁주렁 메달아 요청하는 방식을 get방식이라고 한다.
			
			// 응답 데이터는 "json"임을 처리
			// 웹 상에서 주고 받는 데이터의 타입 : Content-Typr
			con.setRequestProperty("Content-Type", "application/json");
			
			// 접속된 API로부터 데이터를 읽어 들일 입력스트림 생성
			// 1. 정상 스트림과 에러 스트림으로 구분해서 생성
			// 2. API입력 스트림은 오직 byte입력 스트림만 지원하므로 문자입력스트림으로 바꾸는 작업이 필요하다.
			// 3. 속도 향상을 위해서 Buffer가 내장된 스트림을 생성
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				
			
			
			
		}else {
				reader =  new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			//BufferedReader는 readLine 메소드를 지원한다.
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
				
			}
			
			
		// 이제 API의 응답 데이터는 sb에 저장되어 있다.
		//	System.out.println(sb.toString());
		//	API의 응답 데이터를 분석하기 위해서  JSONObject로 변환한다.
		// JSON 라이브러리 사용을 위해서 Build Path 작업을 수행한다.
			
		//)작성방법	
		//JSONObject obj = new JSONObject(sb.toString());
		//JSONObject items = obj.getJSONObject("items");
		//JSONArray itemList = items.getJSONArray("item");
		
		JSONArray itemList = new JSONObject(sb.toString())
										.getJSONObject("items")
										.getJSONArray("item");
		
		List<Accident> list = new ArrayList<Accident>();  //arraylist는 하나만 만들기(for문에 넣으면 안됌)
		for(int i = 0; i < itemList.length(); i++) {
			// 응답 데이터에서 필요한 데이터를 분석(파싱)한다.
			JSONObject item = itemList.getJSONObject(i);
			String occrrncDt = item.getString("occrrnc_dt");
			String occrrncDayCd = item.getString("occrrnc_day_cd");
			int	dthDnvCnt = item.getInt("dth_dnv_cnt");
			int injpsnCnt = item.getInt("injpsn_cnt");   //4개의 변수를 하나의 데이터로 저장하려면 1.bean 또는 2.map으로 저장해야한다.
			// 응답 데이터에서 추출한 데이터를 하나의 객체(Bean)로 만든다.
			Accident accident = new Accident();
			accident.setOccrrncDt(occrrncDt);
			accident.setOccrrncDayCd(occrrncDayCd);
			accident.setDthDnvCnt(dthDnvCnt);
			accident.setInjpsnCnt(injpsnCnt);
			// 객체를 ArrayList에 저장한다.
			list.add(accident);
			
			
			
			
		}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	
		
		

	}

}
