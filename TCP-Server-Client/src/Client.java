import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private String  Accp ="TEXT TCP 1.0";	
	
	public static void main(String[] args) throws IOException{
		Integer port = 8080;
		String add = "localhost";
		Socket conn = new Socket(add,port);
		

	}
	

}
