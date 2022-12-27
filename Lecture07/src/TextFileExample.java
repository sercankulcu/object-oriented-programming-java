import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Here is an example code that demonstrates how to read and write text files in Java:
 * 
 * In this example, we use the BufferedReader and BufferedWriter classes to read from 
 * and write to text files, respectively. The FileReader and FileWriter classes are 
 * used to create the readers and writers, and the readLine() and write() methods are 
 * used to read and write data to the files.
 * 
 * */

public class TextFileExample {
	
  public static void main(String[] args) {
	  
    // Define the file paths
    String inputFilePath = "input.txt";
    String outputFilePath = "output.txt";

    // Read from the input file
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Write to the output file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
      writer.write("This is a line of text.");
      writer.newLine();
      writer.write("This is another line of text.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
