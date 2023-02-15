package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
		
		/*
		 - 상세구현

- 1) 2021년 서울특별시 금천구의 사망교통사고정보를 모두 조회한다.

- 2) 조회된 결과를 이용해서 accident.txt 파일을 생성한다. 파일의 경로는 작성하지 않는다. 예시 File file = new File("accident.txt");

- 3) 다음 값을 저장할 수 있는 Accident 클래스를 생성한다.

        String occrrncDt;  // 발생월일시 (2019011622)

        String occrrncDayCd;  // 발생요일코드 (4)

        int dthDnvCnt;  // 사망자수 (0)

        int injpsnCnt;  // 부상자수 (1)

- 4) 조회된 사고 1건의 정보는 Accident 객체에 저장한다. 조회된 사고 건수만큼 Accident 객체를 생성한다.

- 5) 생성된 모든 Accident 객체를 컬렉션 ArrayList에 모두 저장한다.

 
		 */
		
		String serviceKey = "SJx3sxXn3G3c0OZqCFmximZKaegFUpfy26K/6UCc2D79LdMHvC1wjUSfUDqSgP1C1PH0/X8oG0JTiNvvN6vFUw=="; 
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
		URL url = null;    
		HttpURLConnection con = null;  
		BufferedReader reader = null; 
		BufferedWriter writer = null;
		
		try {
			File file = new File("dsa.txt");
			
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?ServiceKey=" + URLEncoder.encode(serviceKey, "UTF-8")); 
			sbURL.append("&type=json");
			sbURL.append("&searchYear="+2021);
			sbURL.append("&siDo="+1100);
			sbURL.append("&guGun="+1125);
			sbURL.append("&numOfRows=10");
			sbURL.append("&pageNo=1");

			url = new URL(sbURL.toString());
            con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); 
			
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) { 
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
			}else {
				
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream())); 
				
			}
			String line = null; 
			StringBuilder sb =  new StringBuilder();
			while((line = reader.readLine()) != null) {  
				sb.append(line); 
				
			}
			List<Accident> accident = new ArrayList<Accident>();
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray item = obj.getJSONObject("items").getJSONArray("item");
				for(int i= 0; i < item.length(); i++) {
					JSONObject items= item.getJSONObject(i);	
					String occrrncDt = items.getString("occrrnc_dt");
					String occrrncDayCd = items.getString("occrrnc_day_cd");
					int dthDnvCnt = items.getInt("dth_dnv_cnt");
					int injpsnCnt = items.getInt("injpsn_cnt");
					switch(occrrncDayCd) {
					case "1" :  occrrncDayCd = "일"; break;
					case "2" :  occrrncDayCd = "월"; break;
					case "3" :  occrrncDayCd = "화"; break;
					case "4" :  occrrncDayCd = "수"; break;
					case "5" :  occrrncDayCd = "목"; break;
					case "6" :  occrrncDayCd = "금"; break;
					default : occrrncDayCd = "토";
					}
					Accident acc = new Accident(occrrncDt, occrrncDayCd, dthDnvCnt, injpsnCnt);	
					writer = new BufferedWriter(new FileWriter(file));
				writer.write("발생일자" + acc.getOccrrncDt() + " " + acc.getOccrrncDayCd() +  " 사망자" + acc.getDthDnvCnt() + "부상자 " +  acc.getInjpsnCnt());
				System.out.println("발생일자" + occrrncDt + " " + occrrncDayCd +  " 사망자" + dthDnvCnt + "부상자 " +  injpsnCnt);
				accident.add(acc);
				}
						
				writer.close();
				reader.close();
				con.disconnect();
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}		
	
