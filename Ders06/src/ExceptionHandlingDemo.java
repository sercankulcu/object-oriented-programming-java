
public class ExceptionHandlingDemo {

	public static void main(String[] args) {

		try {
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			int z = x / y;
			System.out.println(z);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
			System.out.println("The exception message is: " + e.getMessage());
			System.out.println("The exception stack trace is: " + e.getStackTrace());
		} catch (ArithmeticException e) {
			System.out.println("Division by zero");
			System.out.println("The exception message is: " + e.getMessage());
			System.out.println("The exception stack trace is: " + e.getStackTrace());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Out Of Bounds Exception occured!");
		} finally {
			System.out.println("Entered finally block!");
		}
	}
}
