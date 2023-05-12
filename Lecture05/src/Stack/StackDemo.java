package Stack;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        // Declare a stack of integers
        Stack<Integer> myStack = new Stack<>();

        // Add elements to the stack
        myStack.push(1); // 1
        myStack.push(2); // 2 1
        myStack.push(3); // 3 2 1

        // Print the size of the stack
        System.out.println("The size of the stack is: " + myStack.size());

        // Get the element at the top of the stack
        Integer topElement = myStack.peek();
        System.out.println("The top element of the stack is: " + topElement);

        // Remove the element at the top of the stack
        myStack.pop();

        // Print the stack
        System.out.println("The stack is now: " + myStack);
        
        myStack.push(4); // 4 2 1
        
        // Get the element at the top of the stack
        topElement = myStack.peek();
        System.out.println("The top element of the stack is: " + topElement);
        
        // Print the stack
        System.out.println("The stack is now: " + myStack);
        
    }
}