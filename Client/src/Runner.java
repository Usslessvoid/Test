import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Runner {
	static final int PORT = 2080;
	public static void main(String[] args) {
		try {
			Socket connection = new Socket("localhost", PORT);
											System.out.println("=======>>  >>===");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			boolean stand = true;
			

				System.out.println(in.readLine());

			connection.close();
		} catch (UnknownHostException e) {
			System.out.println("Host don't found!");
		} catch (IOException e) {
			System.out.println("Can't connect to host!");
			e.printStackTrace();
		}

	}

}
