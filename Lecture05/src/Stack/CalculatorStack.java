package Stack;
import java.util.Stack;

/*
 * here is another simple Java program that demonstrates how to use a stack to perform basic 
 * arithmetic operations:
 * 
 * This program takes an array of strings that represent a reverse Polish notation (RPN) 
 * expression and evaluates it. In RPN, the operator follows the operands, so there is no need 
 * for parentheses or operator precedence. 
 * 
 * The program uses a stack to store the operands and perform the operations. For each token 
 * in the expression, if it is an operator, it pops the last two operands off the stack, 
 * performs the operation, and pushes the result back onto the stack. If it is an operand, 
 * it simply pushes it onto the stack.
 * */

public class CalculatorStack {
  public static void main(String[] args) {
    String[] tokens = {"15", "7", "1", "1", "+", "-", "/", "3", "*", "2", "1", "1", "+", "+", "-"};
    double result = evaluate(tokens);
    System.out.println(result);
  }
  
  public static double evaluate(String[] tokens) {
    Stack<Double> stack = new Stack<>();
    
    for (String token : tokens) {
      if (isOperator(token)) {
        double b = stack.pop();
        double a = stack.pop();
        double c = performOperation(a, b, token);
        stack.push(c);
      } else {
        stack.push(Double.parseDouble(token));
      }
    }
    
    return stack.pop();
  }
  
  public static boolean isOperator(String token) {
    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
  }
  
  public static double performOperation(double a, double b, String operator) {
    if (operator.equals("+")) {
      return a + b;
    } else if (operator.equals("-")) {
      return a - b;
    } else if (operator.equals("*")) {
      return a * b;
    } else if (operator.equals("/")) {
      return a / b;
    } else {
      throw new IllegalArgumentException("Invalid operator");
    }
  }
}
