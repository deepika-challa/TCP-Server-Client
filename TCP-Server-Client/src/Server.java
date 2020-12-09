import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		
		
		Integer port = 8080;
		ServerSocket serverSocket = new ServerSocket(port);
		
		while(true) {
			Socket client = serverSocket.accept();
			
			System.out.println("Client Connected");
			
			
			OutputStream dout = client.getOutputStream();
			
			PrintWriter writer = new PrintWriter(dout, true);
			writer.println("TEXT TCP 1.0");
			writer.println("");

			break;
		}
		
		

	}
	

}
	