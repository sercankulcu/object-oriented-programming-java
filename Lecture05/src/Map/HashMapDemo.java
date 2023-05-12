package Map;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {
        // Declare a HashMap of strings
        HashMap<String, String> myMap = new HashMap<>();

        // Add elements to the HashMap
        myMap.put("Apple", "Red");
        myMap.put("Banana", "Yellow");
        myMap.put("Orange", "Orange");

        // Print the size of the HashMap
        System.out.println("The size of the HashMap is: " + myMap.size());

        // Check if an element is present in the HashMap
        System.out.println("Is 'Apple' present in the HashMap? " + myMap.containsKey("Apple"));

        // Get the value associated with the key "Apple"
        String color = myMap.get("Apple");
        System.out.println("The color of Apple is: " + color);

        // Remove an element from the HashMap
        myMap.remove("Banana");

        // Print the HashMap
        System.out.println("The HashMap is now: " + myMap);
    }
}