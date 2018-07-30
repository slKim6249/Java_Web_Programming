package unit.zerg.landed;

import unit.zerg.Landed;
import unit.zerg.Lare;

public class Broodling 
	implements Landed, Lare {

	@Override
	public void attack() {
		System.out.println("브루들링 공격!");
	}

	@Override
	public void move() {
		System.out.println("브루들링 이동!");
	}

	@Override
	public void patrol() {
		System.out.println("브루들링 정찰!");
	}

	@Override
	public void hold() {
		System.out.println("브루들링 대기!");
	}

	@Override
	public void stop() {
		System.out.println("브루들링 정지!");
	}

	@Override
	public void select() {
		System.out.println("브루들링 : 캬악");
	}

}
