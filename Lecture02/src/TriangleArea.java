import java.util.Scanner;

public class TriangleArea {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter the base and height of the triangle
    System.out.print("Enter the base of the triangle: ");
    double base = sc.nextDouble();
    System.out.print("Enter the height of the triangle: ");
    double height = sc.nextDouble();
    sc.close();

    // Calculate the area of the triangle
    double area = (base * height) / 2;

    // Print the result
    System.out.println("The area of the triangle is: " + area);
  }
}
