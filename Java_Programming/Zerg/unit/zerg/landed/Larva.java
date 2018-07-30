package unit.zerg.landed;

import unit.zerg.Hatchery;
import unit.zerg.Hive;
import unit.zerg.Landed;
import unit.zerg.Lare;
import unit.zerg.Revolution;
import unit.zerg.Unit;

public class Larva implements Unit, Landed, Revolution, Hatchery, Lare, Hive {

	@Override
	public void revolution() {
		System.out.println("유닛으로 진화중");
	}

	@Override
	public void attack() {
		System.out.println("공격할 수 없습니다.");
	}

	@Override
	public void move() {
		System.out.println("이동할 수 없습니다.");
	}

	@Override
	public void patrol() {
		System.out.println("정찰할 수 없습니다.");
	}

	@Override
	public void hold() {
		System.out.println("가민히 있을 수 없습니다.");
	}

	@Override
	public void stop() {
		System.out.println("정지할 수 없습니다.");
	}

	@Override
	public void select() {
		System.out.println("꿀꺽");
	}
	
}
