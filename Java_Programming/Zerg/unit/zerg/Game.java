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
		
		List<Hatchery> hatcheryList = new ArrayList<Hatchery>();
		hatcheryList.add( new Larva() );
		hatcheryList.add( new Zergling() );
		
		List<Lare> lareList = new ArrayList<Lare>();
		for( Hatchery h : hatcheryList ) {
			lareList.add( (Lare) h );
		}
		lareList.add( new InfestedTerran() );
		lareList.add( new Broodling() );
		
		List<Hive> hiveList = new ArrayList<Hive>();
		for( Lare l : lareList ) {
			hiveList.add( (Hive) l );
		}
		hiveList.add( new UltraLisk() );
		
		
		for( Hive h : hiveList ) {
			
			if( h instanceof Unit ) {
				Unit unit = (Unit) h;
				unit.attack();
				unit.move();
				unit.hold();
				unit.patrol();
				unit.select();
				unit.stop();
			}
			if ( h instanceof Burrowable ) {
				Burrowable burrow = (Burrowable) h;
				burrow.burrow();
			}
			if( h instanceof Revolution ) {
				Revolution revolution = (Revolution) h;
				revolution.revolution();
			}
			
		}
		
	}
	
}
