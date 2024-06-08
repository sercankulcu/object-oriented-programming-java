
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread
{
	DataInputStream input;
	DataOutputStream output;
	final Socket socket;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public ClientHandler(Socket socket)
	{
		this.socket = socket;
		try {
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run()
	{
		try {
			String str = "";
			//String str2 = "";
			while(!str.equals("stop"))
			{
				str = input.readUTF();
				System.out.println("Received message from client: " + str);
				//str2 = reader.readLine();
				//output.writeUTF(str2);
				output.writeUTF(str);
				output.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
