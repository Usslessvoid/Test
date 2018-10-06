import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Runner {
	static final int PORT = 2080;
	public static void main(String[] args) {
		Socket connection = null;
		BufferedReader inStream = null;
		PrintWriter outStream = null;
		try {
			connection = new Socket("localhost", PORT);
			System.out.println("Success conection.\nEnter -exit to exit.");
			inStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			outStream = new PrintWriter(connection.getOutputStream(),true);
			Scanner user = new Scanner(System.in);
			boolean isWorked = true;
			String command;
			if(inStream.ready()) {
					System.out.println(inStream.readLine());
				}
			while(isWorked) {
				command = user.nextLine();
				outStream.println(command);
				TimeUnit.MILLISECONDS.sleep(50);
				if(inStream.ready()) {
					System.out.println(inStream.readLine());
				}
				if(command.equalsIgnoreCase("-exit")) {
					isWorked = false;
				}
				
			}
			user.close();
		} catch (UnknownHostException e) {
			System.out.println("Host don't found!");
		} catch (IOException e) {
			System.out.println("Can't connect to host!");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(inStream != null) {
					inStream.close();
				}
				if(outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
