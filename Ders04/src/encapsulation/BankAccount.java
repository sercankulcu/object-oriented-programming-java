package encapsulation;

/*
 * In this example, we have a BankAccount class that has accountNumber and balance as instance 
 * variables. These variables are marked as private, which means they can only be accessed from 
 * within the BankAccount class itself.
 * */

public class BankAccount {
  private int accountNumber;
  private double balance;
  
  public BankAccount(int accountNumber, double balance) {
      this.accountNumber = accountNumber;
      this.balance = balance;
  }
  
  public int getAccountNumber() {
      return accountNumber;
  }
  
  public double getBalance() {
      return balance;
  }
  
  public void deposit(double amount) {
      balance += amount;
  }
  
  public void withdraw(double amount) {
      if (balance >= amount) {
          balance -= amount;
      } else {
          System.out.println("Insufficient funds");
      }
  }
}



