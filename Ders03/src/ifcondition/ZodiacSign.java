package ifcondition;
import java.util.Scanner;

/*
 * Here is a Java program that will print the zodiac sign for a given date:
 * 
 * To use this program, you would simply enter your birth month (as a number from 1 to 12) and 
 * your birth day (as a number from 1 to 31) when prompted, and the program will print out your 
 * zodiac sign.
 * 
 * */

public class ZodiacSign {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter your birth month (1-12): ");
    int month = input.nextInt();
    System.out.print("Enter your birth day (1-31): ");
    int day = input.nextInt();

    String zodiacSign = "";
    if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
      zodiacSign = "Aries";
    } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
      zodiacSign = "Taurus";
    } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
      zodiacSign = "Gemini";
    } else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
      zodiacSign = "Cancer";
    } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
      zodiacSign = "Leo";
    } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
      zodiacSign = "Virgo";
    } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
      zodiacSign = "Libra";
    } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
      zodiacSign = "Scorpio";
    } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
      zodiacSign = "Sagittarius";
    } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
      zodiacSign = "Capricorn";
    } else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
      zodiacSign = "Aquarius";
    } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
      zodiacSign = "Pisces";
    }

    System.out.println("Your zodiac sign is: " + zodiacSign);
  }
}
