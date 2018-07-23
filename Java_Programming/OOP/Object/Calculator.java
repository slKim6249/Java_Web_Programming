package Object;

public class Calculator {
	
	int numberOne;
	int numberTwo;
	
	int addResult;
	int divResult;
	
	/**
	 * 두 수의 합계를 구해 출력.
	 */
	
	void printAdditionResult() {
		
		this.addResult = this.numberOne + this.numberTwo;
		System.out.printf("합계 : %d\n", this.addResult);
	}
	
	/**
	 * 두 수의 평균을 구해 출력.
	 */
	
	void printDivisionResult() {
		this.divResult = this.addResult / 2;
		System.out.printf("평균 값 : %d", this.divResult);
	}

}
