package parking;

import java.util.Scanner;

public class ParkingLot {
	
	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	
	public ParkingLot(String name) {
		this.name = name;
		cars =  new Car[10];
		sc = new Scanner(System.in);
	}
	public void addCar() {
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(idx == cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
			
		}
		System.out.print("차량번호 >>> ");
		String carNo = sc.next();
		                             //	next는 공백있으면 거기까지가 입력이 끝난거라고 생각해서 더이상 그뒤에 글자들이 나오지않음
		System.out.print("모델 >>> ");
		String model = sc.next();
		// 다른 풀이 
		//System.out.println("차량번호와 모델명을 순서대로 입력하세요");
		//Car car = new Car(sc.next(), sc.next());   
		
		cars[idx++] = new Car(carNo, model);
		
		System.out.println("차량번호 " + carNo + "차량이 등록되었습니다.");
		
		
		
		
				
		}
	public void deleteCar() {
		
		
	}
		
	public void printAllCars() {
		
		
	}
	public void manage() {
		
		
		while(true) {
			
			System.out.println("1.추가 2.삭제 3.전체 0.종료 >>> ");
			
			String choice = sc.next(); // 숫자로 입력받을때는 nextint
			
			switch(choice) {
			case "1" :
				addCar(); 	// addCar 호출
				break;
			case "2" :
				deleteCar();
				break;
			case "3" :
				printAllCars();
				break;		
			case "0" :
				return;		//manage 메소드 종료		//메소드 반환 타입이 void 라서 메소드 자체가 끝나는 명령 //
				
			default :
				System.out.println("존재하지 않는 메뉴입니다.");
				
			}
			
		}
		
	}
	
	
	}
	
	


