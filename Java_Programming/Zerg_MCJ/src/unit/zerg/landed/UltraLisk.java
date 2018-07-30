package unit.zerg.landed;

import unit.zerg.Hive;
import unit.zerg.Landed;

public class UltraLisk implements Landed, Hive{

	@Override
	public void attack() {
		System.out.println("울트라 리스크 공격!");
	}

	@Override
	public void move() {
		System.out.println("울트라 리스크 이동!");
	}

	@Override
	public void patrol() {
		System.out.println("울트라 리스크 정찰!");
	}

	@Override
	public void hold() {
		System.out.println("울트라 리스크 대기!");
	}

	@Override
	public void stop() {
		System.out.println("울트라 리스크 정지!");
	}

	@Override
	public void select() {
		System.out.println("울트라리스크 : 구우웅");		
	}

}
