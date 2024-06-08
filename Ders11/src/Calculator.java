public class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		return a / b;
	}
	
	public static void main(String[] args)
	{
		Calculator calc = new Calculator();
		int result = calc.add(5, 3);
		System.out.println(result); // prints 8

	}
}
