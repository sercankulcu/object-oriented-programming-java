import java.util.Scanner;

/*
 * Here is a Java program that will take two zodiac signs as input, and calculate a 
 * compatibility score between 0 and 100 based on those signs:
 * 
 * To use this program, you would simply enter the two zodiac signs when prompted, and the 
 * program will print out the computed compatibility score
 * */

public class ZodiacCompatibility {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get the first zodiac sign
    System.out.print("Enter the first zodiac sign: ");
    String sign1 = input.nextLine();

    // Get the second zodiac sign
    System.out.print("Enter the second zodiac sign: ");
    String sign2 = input.nextLine();
    input.close();

    // Calculate the compatibility score
    int compatibilityScore = 0;
    if (sign1.equalsIgnoreCase(sign2)) {
      compatibilityScore = 100;
    } else if ((sign1.equalsIgnoreCase("Aries") && sign2.equalsIgnoreCase("Leo")) ||
               (sign1.equalsIgnoreCase("Leo") && sign2.equalsIgnoreCase("Aries"))) {
      compatibilityScore = 90;
    } else if ((sign1.equalsIgnoreCase("Aries") && sign2.equalsIgnoreCase("Sagittarius")) ||
               (sign1.equalsIgnoreCase("Sagittarius") && sign2.equalsIgnoreCase("Aries"))) {
      compatibilityScore = 80;
    } else if ((sign1.equalsIgnoreCase("Taurus") && sign2.equalsIgnoreCase("Virgo")) ||
               (sign1.equalsIgnoreCase("Virgo") && sign2.equalsIgnoreCase("Taurus"))) {
      compatibilityScore = 70;
    } else if ((sign1.equalsIgnoreCase("Taurus") && sign2.equalsIgnoreCase("Capricorn")) ||
               (sign1.equalsIgnoreCase("Capricorn") && sign2.equalsIgnoreCase("Taurus"))) {
      compatibilityScore = 60;
    } else if ((sign1.equalsIgnoreCase("Gemini") && sign2.equalsIgnoreCase("Libra")) ||
               (sign1.equalsIgnoreCase("Libra") && sign2.equalsIgnoreCase("Gemini"))) {
      compatibilityScore = 50;
    } else if ((sign1.equalsIgnoreCase("Cancer") && sign2.equalsIgnoreCase("Pisces")) ||
               (sign1.equalsIgnoreCase("Pisces") && sign2.equalsIgnoreCase("Cancer"))) {
      compatibilityScore = 40;
    } else if ((sign1.equalsIgnoreCase("Scorpio") && sign2.equalsIgnoreCase("Pisces")) ||
               (sign1.equalsIgnoreCase("Pisces") && sign2.equalsIgnoreCase("Scorpio"))) {
      compatibilityScore = 30;
    } else {
      compatibilityScore = 0;
    }

    // Print the compatibility score
    System.out.println("Compatibility score: " + compatibilityScore + "/100");
  }
}
