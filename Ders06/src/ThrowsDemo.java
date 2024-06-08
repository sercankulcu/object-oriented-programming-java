
public class ThrowsDemo {

    public static void main(String[] args) {
        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero!");
        }
    }

    public static void divide(int x, int y) throws ArithmeticException {
        if (y == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        int z = x / y;
        System.out.println(z);
    }
}
