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

public class client {

	private String Accp = "TEXT TCP 1.0";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String ip = args[0].split(":")[0]; 
		Integer port = Integer.valueOf(args[0].split(":")[1]);
		Socket conn = new Socket(ip, port);

		OutputStream dout = conn.getOutputStream();
		InputStream din = conn.getInputStream();
		System.out.println("Sucessfully connected");

		BufferedReader reader = new BufferedReader(new InputStreamReader(din));
		PrintWriter writer = new PrintWriter(dout, true);
		String msg = "*********";
		boolean process = false;

		int n = 0;

		while (!"".equals(msg)) {	
			
			msg = reader.readLine();
			System.out.println("Recieved: " +msg);

			if (msg.equals("TEXT TCP 1.0")) {				
				//System.out.println("Recieved: TEXT TCP 1.0");
				process = true;
			}

		}
		
		if(process) {
			

			writer.println("OK");
			System.out.println("OK sent");
			// Phase 2
			String cmd = reader.readLine();

			System.out.println("Recieved: " +cmd);
			String[] cmdARR = cmd.split(" ");

			if (cmdARR[0].charAt(0) == 'f') {
				// Float arithmetic
				float value1 = Float.valueOf(cmdARR[1]);
				float value2 = Float.valueOf(cmdARR[2]);
				float ans;

				if (cmdARR[0].equals("fadd")) {
					ans = value1 + value2;

				} else if (cmdARR[0].equals("fmul")) {
					ans = value1 * value2;

				} else if (cmdARR[0].equals("fdiv")) {
					ans = value1 / value2;

				} else {
					ans = value1 - value2;

				}

				writer.println(String.format("%8.8g", ans));
				System.out.println("Sending Ans:" +String.format("%8.8g", ans));

				

			} else {
				int value1 = Integer.valueOf(cmdARR[1]);
				int value2 = Integer.valueOf(cmdARR[2]);
				int ans;
				if (cmdARR[0].equals("add")) {
					ans = value1 + value2;

				} else if (cmdARR[0].equals( "mul")) {
					ans = value1 * value2;
				} else if (cmdARR[0].equals("div")) {
					ans = value1 / value2;
				} else {
					ans = value1 - value2;

				}

				writer.println(String.valueOf(ans));
				System.out.println("Sending Ans:" +String.valueOf(ans));

			}
			
			msg = reader.readLine();
			System.out.println("Recieved: " +msg);
			if (msg.equals("OK")) {
				
				System.out.println("all done");
				}
			
			else {
				
				System.out.println("Recieved  Error");
				
			}
			
			din.close();
	        dout.close();
	        conn.close();
	        System.exit(0);
			
			
			
		}
		

	}

}
