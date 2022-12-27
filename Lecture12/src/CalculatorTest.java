import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
 * Here is a code sample for a JUnit test case in Java:
 * 
 * Eclipse Properties -> Java Build Path -> Libraries -> Add Library -> JUnit -> JUnit 3/4
 * 
 * */

public class CalculatorTest {
  @Test
  public void testAdd() {
    Calculator calculator = new Calculator();
    int result = calculator.add(2, 3);
    assertEquals(5, result);
  }
}
