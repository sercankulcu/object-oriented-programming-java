import java.io.*;

/*
 * Here is a code sample that demonstrates how to handle an IOException in Java:
 * 
 * In this example, we are attempting to open a file for reading and read from it. 
 * If an IOException is thrown while reading from the file (for example, if the file 
 * does not exist or if the file is not readable), the exception is caught and a 
 * message is printed to the console indicating that an error occurred.
 * 
 * */

public class IOExceptionDemo {
	
  public static void main(String[] args) {
	  
    try {
      // Open a file for reading
      FileInputStream fis = new FileInputStream("test.txt");

      // Read from the file
      int data = fis.read();
      while (data != -1) {
        System.out.print((char) data);
        data = fis.read();
      }

      // Close the file
      fis.close();
    } catch (IOException e) {
      // Handle the exception
      System.out.println("An error occurred while reading the file: " + e.getMessage());
    }
  }
}
