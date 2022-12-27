import java.net.*;
import java.io.*;
import java.util.Scanner;

/*
 * Here is a code sample for a basic chat application in Java using sockets:
 * 
 * */

public class ChatClient {

    public static void main(String[] args) throws IOException {
        // Create a socket
        Socket socket = new Socket("localhost", 8000);

        // Create data input and output streams
        DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());

        // Create a scanner to read from the console
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Read a message from the console
            String message = scanner.nextLine();

            // Send the message to the server
            outputToServer.writeUTF(message);

            // Read a message from the server
            message = inputFromServer.readUTF();

            // Display the message
            System.out.println(message);
        }
    }
}

