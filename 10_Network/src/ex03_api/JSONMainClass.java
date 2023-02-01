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
		
		String serviceKey = "SJx3sxXn3G3c0OZqCFmximZKaegFUpfy26K/6UCc2D79LdMHvC1wjUSfUDqSgP1C1PH0/X8oG0JTiNvvN6vFUw==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			String sidoName = "서울";
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8"));
	
			
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
		JSONObject obj = new JSONObject(sb.toString());
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

	public static void main(String[] args) {
		
		ex01();
	}

}
