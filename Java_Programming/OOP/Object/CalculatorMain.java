package Object;

public class CalculatorMain {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		calculator.numberOne = 60;
		calculator.numberTwo = 90;
		
		calculator.printAdditionResult();
		calculator.printDivisionResult();
		
	}

}
