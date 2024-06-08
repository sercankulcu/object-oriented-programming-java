
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerThread
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(4444);
		while (true)
		{
			Socket socket = null;
			try
			{
				socket = serverSocket.accept();
				System.out.println("New client connected : " + socket);
				Thread thread = new ClientHandler(socket);
				thread.start();
			}
			catch (Exception e){
				socket.close();
				serverSocket.close();
				e.printStackTrace();
			}
		}
	}
}
