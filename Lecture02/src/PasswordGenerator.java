import java.util.Random;

/*
 * here is a simple Java program that generates a random password for you:
 * 
 * This program generates a random password of the specified length using a combination 
 * of uppercase and lowercase letters, numbers, and special characters. You can customize 
 * the password length and the set of characters used to generate the password by modifying 
 * the appropriate variables in the code.
 * */

public class PasswordGenerator {
  public static void main(String[] args) {
    int length = 10; // Set the length of the password
    String password = generatePassword(length); // Generate the password
    System.out.println("Your password is: " + password); // Print the password
  }
  
  public static String generatePassword(int length) {
    String password = "";
    Random random = new Random();
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
    
    for (int i = 0; i < length; i++) {
      int index = random.nextInt(characters.length());
      password += characters.charAt(index);
    }
    
    return password;
  }
}
