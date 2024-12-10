package rpc;
import java.rmi.Naming;

/*
 * Here is a simple Java program that demonstrates Remote Procedure Call (RPC) using the 
 * Java RMI (Remote Method Invocation) API:
 * 
 * rmic CalculatorImpl
 * rmiregistry 1099  
*/

public class RPCServer {
  public static void main(String[] args) {
    try {
    	RPCCalculator calculator = new RPCCalculatorImpl();
      Naming.rebind("rmi://localhost:1099/RPCCalculator", calculator);
      System.out.println("Calculator server ready.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
