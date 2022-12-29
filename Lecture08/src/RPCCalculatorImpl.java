import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class RPCCalculatorImpl extends UnicastRemoteObject implements RPCCalculator {
  public RPCCalculatorImpl() throws RemoteException {
    super();
  }
  
  public int add(int a, int b) throws RemoteException {
    return a + b;
  }
  
  public int subtract(int a, int b) throws RemoteException {
    return a - b;
  }
  
  public int multiply(int a, int b) throws RemoteException {
    return a * b;
  }
  
  public int divide(int a, int b) throws RemoteException {
    return a / b;
  }
}