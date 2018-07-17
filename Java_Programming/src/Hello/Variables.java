package Hello;

public class Variables {

	public static void main(String[] args) {
		
		int age = 26;
		long price = 100000000000000L;
		float f = 3.14F;
		double radius = 10.675;
		
		boolean isZombie = true;
		
		String name = "Sangmoo";
		
		System.out.printf("%d, %d, %.2f, %.2f", age, price, f, radius);
		System.out.println("\n"+isZombie);
		System.out.println(name);
	}

}
