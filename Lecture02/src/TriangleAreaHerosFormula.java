import java.util.Scanner;

/*
 * Here is a Java program that calculates the area of a triangle using Hero's formula:
 * 
 * */

public class TriangleAreaHerosFormula {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter the side lengths of the triangle
    System.out.print("Enter the length of side 1: ");
    double side1 = sc.nextDouble();
    System.out.print("Enter the length of side 2: ");
    double side2 = sc.nextDouble();
    System.out.print("Enter the length of side 3: ");
    double side3 = sc.nextDouble();
    sc.close();

    // Calculate the semi-perimeter of the triangle
    double s = (side1 + side2 + side3) / 2;

    // Calculate the area of the triangle using Hero's formula
    double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

    // Print the result
    System.out.println("The area of the triangle is: " + area);
  }
}
