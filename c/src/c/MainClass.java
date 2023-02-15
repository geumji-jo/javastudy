package c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MainClass {
	
	public static void ex01() {
		
		List<String> list = new ArrayList<String>();		
		
		// 저장메소드(저장한 순서대로 저장)
		list.add("봄");
		list.add("여름");
		list.add("가을");
		list.add("겨울");
		
		
		// 하나씩 꺼내보기(저장 메소드가 순서대로 저장 되었기 때문에 꺼내볼때도 인덱스 순서대로 꺼내짐)
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		
		for(int i =0; i <list.size(); i++) {
			System.out.println(list.get(i));
			
		}
		
		System.out.println("---");
		
		for(String season : list) {
			System.out.println(season);
			
			
		
			}
		}

	public static void ex02() {
	
		//TreeMap<K, V>  순서를 정의 해야 할 경우엔 map말고 treemap으로 정의하기
		//ex
	/*	
		TreeMap<Integer, String>  treeMap = new TreeMap<Integer, String>();
		treeMap.put(90, "제시카");
		treeMap.put(100, "블랑카");
		treeMap.put(50, "제레미");
		treeMap.put(80, "사만다");
				
		System.out.println(treeMap);
	*/	
		
		
	Map<Integer, String> map = new HashMap<Integer, String>(); 		//map은 순서는 상관하지 않고 출력함(저장도 마찬가지)
	map.put(1, "a");
	map.put(10, "b");
	map.put(101, "c");
	map.put(11, "d");
	System.out.println(map);
	
	
			
		
		
	}
	public static void ex03() {
		
		
		String name = "제시카";
		String phone = "010-1111-2222";
		int age = 20;		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("age", age + "");
		
		System.out.println(map);
				
		
	}
	public static void ex04() {
		
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("Service-Key", "dfdfd");
	map.put("Cintent-Type", "application/xml");
	
	System.out.println(map.get("Service-key"));
	System.out.println(map.get("application/xml"));
	
	
		ex05(map);
		
	}
	
	public static void ex05(Map<String, Object> map) {
		
		/*
		Set<Entry<String, Object>> set = map.entrySet();
		for( Entry<String, Object> entry : set) {
			}
		*/
		for( Entry<String, Object> entry : map.entrySet()) {
			
			System.out.println(entry.getKey() + ":" + entry.getValue());
			
			
		}
		
	
		
		
		
	}
	
	public static void main(String[] args) {
		
		ex04();

	}

}
