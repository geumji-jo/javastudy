package ex04_OutputStream;

import java.io.Serializable;

/*
	ObjectOutputSTream/ObjectInputStream을 통해서
	객체 입출력을 수행하려면 "반드시" 직렬화 처리를 해야한다.
	
 */

/*
 	직렬화 처리 방법(한꺼번에 데이터를 넘길수 없어서 직렬모양의 데이터로 나누어 보낸다)
 	
 	
 	1. java.io.Serializable 인터페이스를 구현한다.(implements)한다. (필수)
 	2. serialVersionUID 필드 값을 정의한다.(같은 필드값을 가지고 있으면 같은 데이터로 인식) (선택)
 	
 	
 */

public class Person implements Serializable {
	
	

	private static final long serialVersionUID = 7033755836244474051L;  // 시스템에서 자동으로 생성하는 중복이 없는 값
	private String name;
	private int age;
	private double height;
	private boolean isAlive;
	
	public Person() {
		
	}

	public Person(String name, int age, double height, boolean isAlive) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	

}
