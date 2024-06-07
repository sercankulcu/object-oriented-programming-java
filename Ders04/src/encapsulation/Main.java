package encapsulation;

public class Main {
  public static void main(String[] args) {
      BankAccount account = new BankAccount(123456, 1000.0);
      System.out.println("Account number: " + account.getAccountNumber());
      System.out.println("Initial balance: " + account.getBalance());
      account.deposit(500.0);
      System.out.println("Balance after deposit: " + account.getBalance());
      account.withdraw(2000.0);
      System.out.println("Balance after attempted withdrawal: " + account.getBalance());
  }
}