import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		Integer port = 8080;
		ServerSocket serverSocket = new ServerSocket(port);

		Socket client = serverSocket.accept();

		System.out.println("Client Connected");

		OutputStream dout = client.getOutputStream();
		InputStream din = client.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(din));

		PrintWriter writer = new PrintWriter(dout, true);
		writer.println("TEXT TCP 1.0");
		System.out.println("message sent");

		String message = reader.readLine();
		
		// Phase 2 check
		
		if (message.equals("OK")) {
			
			//phase 2 start:
			
			
			
			

		}
		
		

	}

}
