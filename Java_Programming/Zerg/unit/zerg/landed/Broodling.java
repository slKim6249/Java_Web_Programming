package unit.zerg.landed;

import unit.zerg.Hive;
import unit.zerg.Landed;
import unit.zerg.Lare;
import unit.zerg.Unit;

public class Broodling implements Unit, Landed, Lare, Hive {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("브루들링 공격!");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("브루들링 이동!");
	}

	@Override
	public void patrol() {
		// TODO Auto-generated method stub
		System.out.println("브루들링 정찰!");
	}

	@Override
	public void hold() {
		// TODO Auto-generated method stub
		System.out.println("브루들링 대기!");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("브루들링 정지!");
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("캬악");
	}

}
