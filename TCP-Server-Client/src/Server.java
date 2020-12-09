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
import java.util.Random;

public class Server {

	public static void main(String[] args) throws IOException {

		Integer port = 8080;
		ServerSocket serverSocket = new ServerSocket(port);
		
		
		
		
		
		while(true){

		// listen for client
		Socket client = serverSocket.accept();

		System.out.println("Client Connected");

		// initiate input && output streams
		OutputStream dout = client.getOutputStream();
		InputStream din = client.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(din));

		PrintWriter writer = new PrintWriter(dout, true);
		writer.println("TEXT TCP 1.0");
		System.out.println("message sent");

		String message = reader.readLine();

		// Phase 2 check

		if (message.equals("OK")) {

			// phase 2 start:
			System.out.println("Phase 2");

			Random rand = new Random();
			int select = rand.nextInt(8);

			int choice = select % 4; // choose between arithmetic oppERATIONS

			String cmd = "";
			String ans;

			if (select > 3) {
				// generate integer for operations

				int value1 = rand.nextInt();
				int value2 = rand.nextInt();
				
				//send to client
				
				
				if (choice == 0) {
					cmd = "add";
					ans = String.valueOf(value1 + value2);

				} else if (choice == 1) {
					cmd = "mul";
					ans = String.valueOf(value1 * value2);

				}

				else if (choice == 2) {
					cmd = "div";
					ans = String.valueOf(value1 / value2);

				} else {

					cmd = "sub";
					ans = String.valueOf(value1 - value2);

				}
				
				System.out.println(cmd + "\s" + value1 + "\s" + value2);
				writer.println(cmd + "\s" + value1 + "\s" + value2);

			}

			else {
				// generate floating point for operations
				int val1 = rand.nextInt();
				int val2 = rand.nextInt();
				float value1 = val1 + rand.nextFloat();
				float value2 = val2 + rand.nextFloat();
				
				//send to client

				if (choice == 0) {
					cmd = "fadd";
					ans = String.format("%8.8g", value1 + value2);

				} else if (choice == 1) {
					cmd = "fmul";
					ans = String.format("%8.8g",value1 * value2);
				}

				else if (choice == 2) {
					cmd = "fdiv";
					ans = String.format("%8.8g",value1 / value2);

				} else {
					cmd = "fsub";
					ans = String.format("%8.8g",value1 - value2);
				}

				System.out.println(cmd + "\s" + value1 + "\s" + value2);
				writer.println(cmd + "\s" + value1 + "\s" + value2);

			}
			

			String response = reader.readLine();
			
			
			System.out.println("ans is : " +ans);
			System.out.println("response is : "+ response);

			if (response.equals(String.valueOf(ans))) {
				writer.println("OK");

			} else {
				writer.println("ERROR");

			}

		}
		
		
		
		
		///Close connection
		

	}
	}

}
