package Object;

public class ComputerMain {

	public static void main(String[] args) {
		
		Computer com1 = new Computer();
		
		System.out.println(com1.getCpu());
		System.out.println(com1.getGpu());
		System.out.println(com1.getRamList().toString().substring(1,3));
		
		Computer com2 = new Computer("AMD", "Radeon");
		
		System.out.println(com2.getCpu());
		System.out.println(com2.getGpu());
		System.out.println(com2.getRamList().toString().substring(1,3));
	}

}
