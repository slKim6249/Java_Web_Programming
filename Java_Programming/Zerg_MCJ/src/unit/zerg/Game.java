package unit.zerg;

import java.util.ArrayList;
import java.util.List;

import unit.zerg.landed.Broodling;
import unit.zerg.landed.InfestedTerran;
import unit.zerg.landed.Larva;
import unit.zerg.landed.UltraLisk;
import unit.zerg.landed.Zergling;

public class Game {

	public static void main(String[] args) {
		new Game().run();
	}
	
	public void run() {
		
		List<Hatchery> hatcheryUnitList = new ArrayList<Hatchery>();
		hatcheryUnitList.add(new Larva());
		hatcheryUnitList.add(new Zergling());
		
		List<Lare> lareUnitList = new ArrayList<Lare>();
		lareUnitList.addAll(hatcheryUnitList);
		lareUnitList.add(new InfestedTerran());
		lareUnitList.add(new Broodling());
		
		List<Hive> hiveUnitList = new ArrayList<Hive>();
		hiveUnitList.addAll(lareUnitList);
		hiveUnitList.add(new UltraLisk());
		
		for ( Hive h : hiveUnitList ) {
			if ( h instanceof Unit ) {
				Unit unit = (Unit) h;
				unit.select();
				unit.hold();
				unit.patrol();
				unit.stop();
				unit.attack();
				unit.move();
			}
			if ( h instanceof Burrowable ) {
				Burrowable burrow = (Burrowable) h;
				burrow.burrow();
			}
			if ( h instanceof Revolution ) {
				Revolution rev = (Revolution) h;
				rev.revolution();
			}
		}
		
		
	}
	
}












