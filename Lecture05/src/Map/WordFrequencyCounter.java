package Map;
import java.util.Map;
import java.util.HashMap;

/*
 * here is another simple Java program that demonstrates how to use a map to count 
 * the frequency of words in a piece of text:
 * 
 * This program takes a piece of text and splits it into an array of words. It then uses a map 
 * to count the frequency of each word in the text. The map is initialized with a HashMap, which 
 * is a implementation of the Map interface that uses a hash table to store the key-value pairs.
 * */

public class WordFrequencyCounter {
  public static void main(String[] args) {
    String text = "The quick brown fox jumps over the lazy dog.";
    
    Map<String, Integer> frequencyMap = new HashMap<>();
    
    String[] words = text.split(" ");
    for (String word : words) {
      word = word.toLowerCase();
      if (frequencyMap.containsKey(word)) {
        int count = frequencyMap.get(word);
        frequencyMap.put(word, count + 1);
      } else {
        frequencyMap.put(word, 1);
      }
    }
    
    for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
      String word = entry.getKey();
      int count = entry.getValue();
      System.out.println(word + ": " + count);
    }
  }
}
