package Object;

public class CalculatorMain {

	public static void main(String[] args) {
		
		int number = 100;
		Calculator calculator = new Calculator();
		
		calculator.numberOne = 60;
		calculator.numberTwo = 90;
		
		calculator.printAdditionResult();
		calculator.printDivisionResult();
		
		System.out.println(number);
		System.out.println(calculator);
		
	}

}
