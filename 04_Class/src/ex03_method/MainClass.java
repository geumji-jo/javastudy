package ex03_method;

public class MainClass {
	
	public static void ex01() {		//계산기
		
		//calculator  객체 선언 + 생성
		Calculator calc = new Calculator();
		
		double add = calc.addition(1.5, 2.5);	// addition 메소드 호출
		System.out.println(add);		
		
		double sub = calc.subtraction(2.5, 1.5);
		System.out.println(sub);
		
	} 
	
	public static void ex02() {		// 커피머신
		
		CoffeeMachine coffeeMachine = new CoffeeMachine();		
		
		CoffeeAndChange coffeeAndChange = coffeeMachine.buyCoffe(500, 1);
		System.out.println(coffeeAndChange.coffee);
		System.out.println(coffeeAndChange.change);
		
		System.out.println(coffeeMachine.moneyPot);
		
	}

	public static void ex03() {		//자동차
		
		Car car = new Car();
		
		car.addOil(100);
		
		for(int n = 0; n <51; n++) {
			car.pushAccel();
		}
		
		System.out.println(car.oilPot);
		System.out.println(car.carSpeed);
		
		for(int n = 0; n < 5; n++) {
			car.pushBreak();
		}	
		
		System.out.println(car.oilPot);
		System.out.println(car.carSpeed);		
		
	}
	
	public static void main(String[] args) {
		ex03();
	}
}
