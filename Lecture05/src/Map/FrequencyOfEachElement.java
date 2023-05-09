package Map;
import java.util.HashMap;
import java.util.Map;

/*
 * Here is a Java code example that finds the frequency of each element in an array:
 * 
 * */

public class FrequencyOfEachElement {
	
  public static void findFrequencyByUsingMap(int[] array) {
  	
    // Create a map to store the frequencies of the elements
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int element : array) {
      // If the element is already in the map, increment its frequency by 1
      if (frequencyMap.containsKey(element)) {
        int frequency = frequencyMap.get(element);
        frequencyMap.put(element, frequency + 1);
      } else {
        // If the element is not in the map, add it with a frequency of 1
        frequencyMap.put(element, 1);
      }
    }
    // Print the frequencies of all elements in the map
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
  
  public static void findFrequency(int[] array) {
    // Create an array to store the frequencies of the elements
    int[] frequency = new int[array.length];
    for (int element : array) {
      frequency[element]++;
    }
    // Print the frequencies of all elements in the array
    for (int i = 0; i < frequency.length; i++) {
      if (frequency[i] > 0) {
        System.out.println(i + ": " + frequency[i]);
      }
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 1, 2, 3, 3, 3, 4, 5, 5};
    findFrequencyByUsingMap(array);
    findFrequency(array);
  }
}
