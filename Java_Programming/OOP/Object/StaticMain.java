package Object;

public class StaticMain {

	/**
	 * Class Method
	 * @param args
	 */
	public static void main(String[] args) {
		
		new StaticMain().run();
		
	}
	
	/**
	 * Instance Method
	 */
	public void run() {
		/*
		 * Class를 가지고 접근
		 */
		System.out.println( Static.message );
		Static.printMessage();
		Static.printMessage("상무");
		
		System.out.println( Math.PI );
		
		int number = 100;
		String num = String.valueOf(number);
		System.out.println(num);
	}

}
