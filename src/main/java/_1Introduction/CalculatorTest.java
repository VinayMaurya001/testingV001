package _1Introduction;

public class CalculatorTest {

	public static void main(String[] args) {
		CalculatorTest calculatorTest = new CalculatorTest();
		calculatorTest.testAdd();
		calculatorTest.testAdd2();
		calculatorTest.testAdd3();
	}

	void testAdd() {
		Calculator calculator = new Calculator();
		int actualSum = calculator.add(2, 3);
		int expectedSum = 5;
		if (expectedSum != actualSum) {
			System.out.println("testAdd failed");
			throw new AssertionError("testAdd failed");
		}
	}

	void testAdd2() {
		Calculator calculator = new Calculator();
		int actualSum = calculator.add(2, 3);
		int expectedSum = 4;
		assert expectedSum == actualSum;
	}

	void testAdd3() {
		Calculator calculator = new Calculator();
		int actualSum = calculator.add(2, 3);
		int expectedSum = 4;
		assert expectedSum == actualSum : "testAdd2 failed";
	}

}
