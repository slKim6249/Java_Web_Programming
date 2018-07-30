package unit.zerg.landed;

import unit.zerg.Burrowable;
import unit.zerg.Hatchery;

public class Zergling 
		implements Hatchery, Burrowable {

	@Override
	public void burrow() {
		System.out.println("저글링 숨기!");
	}

	@Override
	public void attack() {
		System.out.println("저글링 공격!");
	}

	@Override
	public void move() {
		System.out.println("저글링 이동!");
	}

	@Override
	public void patrol() {
		System.out.println("저글링 정찰!");
	}

	@Override
	public void hold() {
		System.out.println("저글링 대기!");
	}

	@Override
	public void stop() {
		System.out.println("저글링 정지!");
	}

	@Override
	public void select() {
		System.out.println("저글링 : 츄릅");
	}

}
