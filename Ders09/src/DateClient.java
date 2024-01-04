import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;

/**
 * A command line client for the date server. Requires the IP address of the
 * server as the sole argument. Exits after printing the response.
 */
public class DateClient {
	public static void main(String[] args) throws IOException {

		try (var socket = new Socket("localhost", 59090)) {
			var in = new Scanner(socket.getInputStream());
			System.out.println("Server response: " + in.nextLine());
		}
	}
}