package unit.zerg.landed;

import unit.zerg.Landed;
import unit.zerg.Lare;

public class InfestedTerran 
	implements Landed, Lare {

	@Override
	public void attack() {
		System.out.println("인페스티드테란 공격!");
	}

	@Override
	public void move() {
		System.out.println("인페스티드테란 이동!");
	}

	@Override
	public void patrol() {
		System.out.println("인페스티드테란 정찰!");
	}

	@Override
	public void hold() {
		System.out.println("인페스티드테란 대기!");
	}

	@Override
	public void stop() {
		System.out.println("인페스티드테란 정지!");
	}

	@Override
	public void select() {
		System.out.println("인페스티드테란 : 펑");
	}

}
