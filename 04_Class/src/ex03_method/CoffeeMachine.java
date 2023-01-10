package ex03_method;

public class CoffeeMachine {
	
	// 필드
	int meneyPot;
	String[] menu = {"아메리카노", "카페라떼", "마끼야또"};
	int[] prices = {900, 1500, 2000};
	
	// 메소드
	CoffeeAndChange buyCoffe(int money,int choice) {
		String coffee = menu[choice -1];
		int price = prices[choice -1];
		
		meneyPot += price;
		
		CoffeeAndChange cnc = new CoffeeAndChange();
		cnc.coffee = coffee;
		cnc.change = money - price;
		return cnc;
		

	}
	

}
