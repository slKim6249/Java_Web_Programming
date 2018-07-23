package Object;

public class CarMain {

	public static void main(String[] args) throws InterruptedException {
		
		Car car = new Car();
		Thread th = new Thread();
		
		car.onKey = true;
		car.signal = true;
		car.road = 200;
		
		while ( car.onKey ) {
			
			th.sleep(3000);
			
			if ( car.onKey == true ) {
				car.run(car.road);
				
				if( car.road < 0 ) {
					break;
				} else {
					car.roadDrive();
					if( car.signal == true ) {
						if ( car.road < 0 ) {
							break;
						}
						car.stop();
						car.signalChange();
						car.roadDrive();
					}
				}
			}
		}
		car.endRoad();
	}
}
