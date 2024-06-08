import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/*
 * Here is a code sample for a JUnit test case in Java:
 * 
 * Eclipse Properties -> Java Build Path -> Libraries -> Add Library -> JUnit -> JUnit 3/4
 * 
 * */

public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@BeforeEach
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void testAdd() {
		assertEquals(5, calculator.add(2, 3));
		assertEquals(-1, calculator.add(-2, 1));
		assertEquals(0, calculator.add(-2, 2));
	}

	@Test
	public void testSubtract() {
		assertEquals(1, calculator.subtract(3, 2));
		assertEquals(-3, calculator.subtract(-2, 1));
		assertEquals(0, calculator.subtract(2, 2));
	}

	@Test
	public void testMultiply() {
		assertEquals(6, calculator.multiply(2, 3));
		assertEquals(-2, calculator.multiply(-2, 1));
		assertEquals(0, calculator.multiply(0, 2));
	}

	@Test
	public void testDivide() {
		assertEquals(2, calculator.divide(6, 3));
		assertEquals(-2, calculator.divide(-4, 2));

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			calculator.divide(1, 0);
		});

		assertEquals("Division by zero is not allowed.", exception.getMessage());
	}
}
