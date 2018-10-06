package by.training.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class ServerThread extends Thread {
	ServerSocket socket;
	public ServerThread(ServerSocket socket) {
	super();
	this.socket = socket;
	}

	@Override
	public void run() {
			Socket client;
			BufferedReader input = null;
			PrintWriter output = null;
			try {
				client = socket.accept();
				System.out.println("Successful connection! " + client.getInetAddress().toString());
				Runner.addServerThread(socket);
				input = new BufferedReader(new InputStreamReader(client.getInputStream()));
				output = new PrintWriter(client.getOutputStream(),true);
			}catch (IOException e) {
				System.err.println("Can't create connection ");
				System.exit(-1);
			}
			try {
				output.println("You conected to eco server.");
				String command;
				boolean isWorked = true;
				while(isWorked) {
					if(input.ready()) {
						command = input.readLine();
						output.println(command);
						if(command.equalsIgnoreCase("-exit")) {
							isWorked = false;
						}
					}
					TimeUnit.MICROSECONDS.sleep(5);
				}
			} catch (IOException e) {
				System.err.println("Cannot answer");
			}catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				if(input != null) {
					input.close();
				}
				if(output != null) {
					output.close();
				}
			}catch (IOException e) {
				System.err.println("Streams not closed");
			}
			try {
				this.finalize();
			} catch (Throwable e) {
				System.out.println("Can't clear memory");
				e.printStackTrace();
			}
		}
}
