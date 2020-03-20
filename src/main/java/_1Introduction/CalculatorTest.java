package _1Introduction;

public class CalculatorTest {

	public static void main(String[] args) {

		testAdd();
		testAdd2();
		testAdd3();
	}

	static void testAdd() {
		Calculator calculator = new Calculator();
		int expectedSum = 5;
		int actualSum = calculator.add(2, 3);
		if (expectedSum != actualSum) {
			System.out.println("testAdd failed");
		}
	}

	static void testAdd2() {
		Calculator calculator = new Calculator();
		int expectedSum = 4;
		int actualSum = calculator.add(2, 3);
		assert expectedSum == actualSum ;
	}
	static void testAdd3() {
		Calculator calculator = new Calculator();
		int expectedSum = 4;
		int actualSum = calculator.add(2, 3);
		assert expectedSum == actualSum : "testAdd2 failed";
	}

	
}
