package Object;

public class Hello {
	
	public String hello() {
		return "안녕하세요";
	}
	
	public String hello(String name) {
		return name + "님, 안녕하세요";
	}
	
	public static void main(String[] args) {
		
		new Hello().run();
		
	}
	
	public void run() {
		
		String message = hello();
		System.out.println(message);
		
		message = hello("상무");
		System.out.println(message);
		
	}
	
}
