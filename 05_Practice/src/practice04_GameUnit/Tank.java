package practice04_GameUnit;

public class Tank extends GameUnit {

	// 생성자
	public Tank(String name) {
		super(name, 100, 10);
	}
	
	// attack 메소드
	@Override
	public void attack(GameUnit unit) {
		
		// 10% 확률로 KO 시킬 수 있다.
		if(Math.random() < 0.1) {
			unit.setEnergy(0);
			unit.setAlive(false);
			System.out.println(unit.getName() + "을 한 방에 죽였다.");
		} else {
			int unitEnergy = unit.getEnergy() - getPower()  < 0 ? 0 : unit.getEnergy() - getPower();
			unit.setEnergy(unitEnergy);
			unit.setAlive(unitEnergy > 0);
			System.out.println(unit.getName() + "의 남은 에너지 " + unit.getEnergy());
		}
		
	}
	
}
