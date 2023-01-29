package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVMainClass {

	public static void main(String[] args) {
		
		
		// C:\storage\product.csv 읽기
		
		File file = new File("C:" + File.separator +"storage", "product.csv");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			
			String line = null;
			while((line = br.readLine()) != null) {
				String[] items = line.split(",");
				Map<String, Object> product = new HashMap<String, Object>();
				product.put("model", items[0]);
				product.put("maker", items[1]);
				product.put("price", Integer.parseInt(items[2]));	// 아이템[2]는 int 타입이라서 parseInt로 강제변환(기존 배열은 String)
				
				products.add(product); 		//제품들에 제품넣기
			}
			System.out.println(products);
		}catch (IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}
}
