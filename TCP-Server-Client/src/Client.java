import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private String  Accp ="TEXT TCP 1.0";	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Integer port = 8080;
		String add = "localhost";
		Socket conn = new Socket(add,port);
		System.out.println("Sucessfully connected");
		
		OutputStream dout = conn.getOutputStream();
		InputStream din =  conn.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(din));
		String message = reader.readLine();    
		
		

	}
	

}
