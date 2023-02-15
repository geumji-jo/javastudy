package ex03_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {
	
	private static void ex01() {
		
		String serviceKey = "SJx3sxXn3G3c0OZqCFmximZKaegFUpfy26K/6UCc2D79LdMHvC1wjUSfUDqSgP1C1PH0/X8oG0JTiNvvN6vFUw==";   //디코딩된 서비스키적기
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		URL url = null;     // try catch 문에 exception(예외처리) 하기위해서 바깥에 null값으로 초기화
		HttpURLConnection con = null;    //con = stream
		BufferedReader reader = null; // 빨리 읽을라고.....
		
		try {
			String sidoName = "서울";
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));  // 웬만하면 필수 값/  UTF-8 한글변환인코딩 때문에 써주는,.... 
			sbURL.append("&returnType=json"); //JSON형식으로 받아야해서...
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8")); // URLEncoder.encode  = 한글(sidoname) 값을 인코딩해줘야 한다.그래야 컴퓨터가 알아먹는다...
	
			
			url =  new URL(sbURL.toString());  // toString은 가독성을 위헤ㅐ...?굳이 안써도됌//하지만 원칙적으로 toString은 꼭 써줘야함
			con= (HttpURLConnection) url.openConnection(); //con 과 타입을 맞춰주기 위해
			
			con.setRequestMethod("GET"); //get 방식 =주소창으로 데이터를 입력 받는거..?post방식도 있음(주로 로그인 할때,..)
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); //우리가 내려받을 타입 제이슨의 컨텐츠타입을 지정하는 방법
			
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) { //getResponseCode() = 
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  //byte바이트를 받아온다 /InputStreamReader = 한글처리 가능한 바이트스트림 //buffered~ 빨리처리
			}else {
				
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream())); //getErrorStream( 제대로 연결되지 않았을때 발동...에러가 났을때 내용을 보여주는 스트림...?
				
			}
			String line = null; //String line 쓸라고....초기화...
			StringBuilder sb =  new StringBuilder();
			while((line = reader.readLine()) != null) {   //readLine :버퍼드 리드에서 사용할 수 있는 메서드.한줄씩 읽어들인다...
				sb.append(line); 
				
			}
					
		reader.close();
		con.disconnect();
		
		System.out.println(sb.toString());
		JSONObject obj = new JSONObject(sb.toString());   //JSONObject가 json안에 있는 라이브러리를 사용하기 위해 불러오는 기능...?
	//	JSONObject obj2 = obj.getJSONObject("response");
	//	JSONObject obj3 = obj2.getJSONObject("body");
		
		
		//obj3== body 
		
		JSONObject body = obj.getJSONObject("response").getJSONObject("body");
	//	int totalCount = obj3.getInt("totalCount");
		//System.out.println(totalCount);
		JSONArray items = body.getJSONArray("items");
		for(int i= 0; i < items.length(); i++) {
			JSONObject item = items.getJSONObject(i);	//JSONPBJECT가 된다
			String stationName =  item.getString("stationName");
			String pm10Value = item.getString("pm10Value");
			String o3Value = item.getString("o3Value");
			System.out.println(stationName + " : 미세먼지 - " +pm10Value + ", 초미세먼지 - " + o3Value );
		
		}
				

		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void ex02() {
		
		
		
	
		String serviceKey = "SJx3sxXn3G3c0OZqCFmximZKaegFUpfy26K/6UCc2D79LdMHvC1wjUSfUDqSgP1C1PH0/X8oG0JTiNvvN6vFUw==";
		String apiURL =  "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		
		try {
		
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&searchDate=2023-01-30");
	
			System.out.println(sbURL);
			url =  new URL(sbURL.toString());
			con= (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; ; charset=UTF-8");
			
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
			}
			String line = null;
			StringBuilder sb =  new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
				
			}
					
		reader.close();
		con.disconnect();
		System.out.println(sb.toString());
		
		JSONArray items = new JSONObject(sb.toString())
								.getJSONObject("response")
								.getJSONObject("body")
								.getJSONArray("items");
		
		
		for(int i = 0; i < items.length(); i ++) {
			JSONObject item = items.getJSONObject(i);
			System.out.println(item.getString("frcstOneDt") + " : " + item.getString("frcstOneCn"));
			System.out.println(item.getString("frcstTwoDt") + " : " + item.getString("frcstTwoCn"));
			System.out.println(item.getString("frcstThreeDt") + " : " + item.getString("frcstThreeCn"));
			System.out.println(item.getString("frcstFourDt") + " : " + item.getString("frcstFourCn"));
		}
			
		
		
		}catch (Exception e) {
			e.printStackTrace();
			
			
		}
		

	}

	public static void main(String[] args) {
		
		ex02();
		
	}

}
