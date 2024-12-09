import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIOExample {

    public static void main(String[] args) throws Exception {
        // Create a File object for the file to read from.
        File inputFile = new File("myfile.txt");

        // Create a FileInputStream object for the input file.
        FileInputStream inputStream = new FileInputStream(inputFile);

        // Create a byte array to store the data read from the file.
        byte[] data = new byte[(int) inputFile.length()];

        // Read the data from the file into the byte array.
        int bytesRead = inputStream.read(data);
        
        System.out.println("bytesRead: " + bytesRead);

        // Close the input stream.
        inputStream.close();

        // Create a File object for the file to write to.
        File outputFile = new File("myoutput.txt");

        // Create a FileOutputStream object for the output file.
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        // Write the data from the byte array to the output file.
        outputStream.write(data);

        // Close the output stream.
        outputStream.close();
    }
}