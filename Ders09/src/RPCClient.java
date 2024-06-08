import java.rmi.Naming;

/*
 * Here is a simple Java program that demonstrates Remote Procedure Call (RPC) using the 
 * Java RMI (Remote Method Invocation) API:
 * 
 * rmic CalculatorImpl
 * rmiregistry 1099  
*/

public class RPCClient {
  public static void main(String[] args) {
    try {
      RPCCalculator calculator = (RPCCalculator) Naming.lookup("rmi://localhost:1099/RPCCalculator");
      int result = calculator.add(3, 4);
      System.out.println(result); // 7
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}