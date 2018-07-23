package Object;

public class Car {
	
	boolean onKey;
	boolean signal;
	int road;
	
	void run(int road) {
		System.out.println("목적지까지 " + road + "m남았습니다.");
	}
	
	void stop() {
		System.out.println("신호 정지합니다.");
	}
	
	void signalChange() {
		System.out.println("신호가 바뀌었습니다.\n주행하세요");
	}
	
	int roadDrive() {
		System.out.println("서행합니다.");
		
		road -= 70;
		
		return road;
	}
	
	void endRoad() {
		System.out.println("목적지에 도착했습니다.");
	}
	
}
