package Object;

public class Static {
	
	/**
	 * Class Fields
	 */
	public static String message = "안녕하세요";
	
	/**
	 * Instance Fields
	 */
	private String message2;
	
	/**
	 * Class Method
	 */
	public static void printMessage() {
		System.out.println(message);
	}
	
	/**
	 * Class Method (Method Overloading)
	 * @param name
	 */
	public static void printMessage(String name) {
		System.out.println(name + "님 " + message);
	}
	
}
