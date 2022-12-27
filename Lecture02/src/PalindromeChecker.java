import java.util.Scanner;

/*
 * Here is a Java code example that checks whether a given number is a palindrome:
 * 
 * */

public class PalindromeChecker {
	
  public static boolean isPalindrome(int num) {
  	
    int originalNum = num;
    int reverseNum = 0;
    while (num > 0) {
      int digit = num % 10;
      reverseNum = (reverseNum * 10) + digit;
      num /= 10;
    }
    return originalNum == reverseNum;
  }

  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check if it is palindrome: ");
		int num = sc.nextInt();
		sc.close();
    if (isPalindrome(num)) {
      System.out.println(num + " is a palindrome.");
    } else {
      System.out.println(num + " is not a palindrome.");
    }
  }
}
