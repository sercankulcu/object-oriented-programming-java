import java.util.Scanner;

public class Login {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Username: ");
    String username = scanner.nextLine();
    
    System.out.print("Password: ");
    String password = scanner.nextLine();
    scanner.close();
    
    // Check if the username and password are correct
    if (username.equals("admin") && password.equals("password")) {
      System.out.println("Logged in successfully");
    } else {
      System.out.println("Invalid username or password");
    }
  }
}
