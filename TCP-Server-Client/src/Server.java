import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		
		
		Integer port = 8080;
		ServerSocket serverSocket = new ServerSocket(port);
		
		while(true) {
			Socket client = serverSocket.accept();
			
			DataInputStream in=new DataInputStream(client.getInputStream());  	  
			DataOutputStream out=new DataOutputStream(client.getOutputStream());
			
			out.writeUTF("TEXT TCP 1.0\n");
			out.writeUTF("\n");
			
			

			
		}
		
		

	}
	

}
	