import java.util.LinkedList;
import java.util.Queue;

/*
 * Here is a code that demonstrates the use of a queue in Java:
 * 
 * */

public class QueueExample {
	
  public static void main(String[] args) {
	  
    // create a queue
    Queue<String> queue = new LinkedList<>();
    
    // add elements to the queue
    queue.add("apple");
    queue.add("banana");
    queue.add("cherry");
    
    // print the queue
    System.out.println("Queue: " + queue);
    
    // remove an element from the queue
    String removedElement = queue.remove();
    System.out.println("Removed element: " + removedElement);
    
    // print the queue after removing an element
    System.out.println("Queue: " + queue);
    
    // peek at the first element of the queue
    String firstElement = queue.peek();
    System.out.println("First element: " + firstElement);
    
    // print the queue after peeking at the first element
    System.out.println("Queue: " + queue);
  }
}
