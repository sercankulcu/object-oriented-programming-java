import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {
        // Declare a Vector of integers
        Vector<Integer> myVector = new Vector<>();

        // Add elements to the Vector
        myVector.add(1);
        myVector.add(2);
        myVector.add(3);
        myVector.add(4);

        // Print the size of the Vector
        System.out.println("The size of the Vector is: " + myVector.size());

        // Get the element at index 0
        Integer element = myVector.get(0);
        System.out.println("The element at index 0 is: " + element);

        // Remove the element at index 1
        myVector.remove(1);

        // Print the Vector
        System.out.println("The Vector is now: " + myVector);
    }
}