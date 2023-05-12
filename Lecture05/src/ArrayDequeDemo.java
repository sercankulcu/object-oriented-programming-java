
import java.util.ArrayDeque;

public class ArrayDequeDemo {

    public static void main(String[] args) {
        // Declare an ArrayDeque of integers
        ArrayDeque<Integer> myDeque = new ArrayDeque<>();

        // Add elements to the Deque
        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addLast(3); // 2 1 3

        // Print the size of the Deque
        System.out.println("The size of the Deque is: " + myDeque.size());

        // Get the element at the front of the Deque
        Integer firstElement = myDeque.getFirst();
        System.out.println("The first element of the Deque is: " + firstElement);

        // Get the element at the back of the Deque
        Integer lastElement = myDeque.getLast();
        System.out.println("The last element of the Deque is: " + lastElement);

        // Remove an element from the front of the Deque
        myDeque.removeFirst();

        // Print the Deque
        System.out.println("The Deque is now: " + myDeque);
    }
}