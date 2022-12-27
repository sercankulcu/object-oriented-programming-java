import java.net.*;
import java.io.*;

/*
 * Here is a code sample for a basic chat application in Java using sockets:
 * 
 * */

public class ChatServer {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        // Listen for a connection request
        Socket socket = serverSocket.accept();

        // Create data input and output streams
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

        while (true) {
            // Read a message from the client
            String message = inputFromClient.readUTF();

            // Send the message back to the client
            outputToClient.writeUTF(message);
        }
    }
}

