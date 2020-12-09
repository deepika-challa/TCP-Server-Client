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

	private String Accp = "TEXT TCP 1.0";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Integer port = 8080;
		String add = "localhost";
		Socket conn = new Socket(add, port);

		OutputStream dout = conn.getOutputStream();
		InputStream din = conn.getInputStream();
		System.out.println("Sucessfully connected");

		BufferedReader reader = new BufferedReader(new InputStreamReader(din));
		PrintWriter writer = new PrintWriter(dout, true);
		String msg = "";

		int n = 0;

		while (!"\n".equals(msg)) {
			System.out.println("*" + msg);

			msg = reader.readLine();

			if (msg.equals("TEXT TCP 1.0")) {
				writer.println("OK");
				System.out.println("OK sent");
				// Phase 2
				String cmd = reader.readLine();

				System.out.println("cmd: " + cmd);
				String[] cmdARR = cmd.split("\s");

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

				}
				
				msg = reader.readLine();

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

}
