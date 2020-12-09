import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private String  Accp ="TEXT TCP 1.0";	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Integer port = 8080;
		String add = "localhost";
		Socket conn = new Socket(add,port);
		
		OutputStream dout = conn.getOutputStream();
		InputStream din =  conn.getInputStream();
		System.out.println("Sucessfully connected");

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(din));
		PrintWriter writer = new PrintWriter(dout, true);
		String msg= "";
		
		String [] messages;		
		int n=0;
		
		while (!"\n".equals(msg)) {
			System.out.print("*"+msg);
			
			msg = reader.readLine();    
			
			System.out.println("line read");
			if(msg.equals("TEXT TCP 1.0")) {
				writer.println("OK");
				System.out.println("OK sent");
				//Phase 2
				
				
				
				
				
		
			}

			
		}

	}
	

}
