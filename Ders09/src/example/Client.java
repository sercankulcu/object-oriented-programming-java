package example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
public class Client {
	
	public static void main(String args[]) throws Exception {
		
		Socket socket = new Socket("localhost", 4444);
		DataInputStream input = new DataInputStream(socket.getInputStream());
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		String str2 = "";
		
		while(!str.equals("stop")){
			str = reader.readLine();
			output.writeUTF(str);
			output.flush();
			str2 = input.readUTF();
			System.out.println("Received message from server: " + str2);
		}
		input.close();
		output.close();
		reader.close();
		socket.close();
	}
} 