import java.util.Scanner;

public class GreatestCommonDivisor {
	
	public static int gcd(int a, int b) { 
    if (b == 0) 
      return a; 
    return gcd(b, a % b);  
  }
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find the gcd: ");
		int num1 = sc.nextInt();
		System.out.print("Enter a number to find the gcd: ");
		int num2 = sc.nextInt();
		sc.close();
		
		int result = GreatestCommonDivisor.gcd(num1, num2);
		System.out.print(result);
	}

}
