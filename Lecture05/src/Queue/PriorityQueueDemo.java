package Queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        // Declare a PriorityQueue of integers
        PriorityQueue<Integer> myQueue = new PriorityQueue<>();

        // Add elements to the Queue
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        // Print the size of the Queue
        System.out.println("The size of the Queue is: " + myQueue.size());

        // Get the element at the head of the Queue
        Integer firstElement = myQueue.peek();
        System.out.println("The first element of the Queue is: " + firstElement);

        // Remove and get the element at the head of the Queue
        Integer removedElement = myQueue.poll();
        System.out.println("The element removed from the Queue is: " + removedElement);

        // Print the Queue
        System.out.println("The Queue is now: " + myQueue);
    }
}