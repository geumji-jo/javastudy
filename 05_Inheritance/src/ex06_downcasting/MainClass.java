package ex06_downcasting;

public class MainClass {
	
	public static void ex01() {
		
		//upcasting
		Person person = new Student();	// 자식을 부모 타입에 저장
		
		//downcasting
		Student student = (Student)person;
		
		student.eat();
		student.sleep();
		student.study();
		
		
	}

	
public static void ex02() {
		
		//Person
		Person person = new Person();	// 자식을 부모 타입에 저장
		
		//잘못된 캐스팅
		Student student = (Student)person;
		
		
		// 잘못된 캐스팅은 컴파일 오류(빨간줄)로 걸러지지 않는다. 
		student.eat();
		student.sleep();
		student.study(); // 오류 발생 부분
		
public static void ex03() {
	
	// Person
	Person person = new Person();  //메모리에 저장되서 형태가 갖춰진 것 = 인스턴스 = 객체
	
	//Student객체(인스턴스, instance)가 맞다면 Student타입으로 캐스팅하자.
	if(person instanceof Student) { 
		
		Student student = (Student)person;
		student.eat();
		student.sleep();
		student.study();
		
		person.eat();
		person.sleep();
		((Student)person).study();
		
	}
	
}
		
	
	public static void main(String[] args) {
		ex03();
		
	}

}
